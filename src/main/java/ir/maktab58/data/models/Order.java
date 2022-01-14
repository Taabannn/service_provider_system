package ir.maktab58.data.models;

import ir.maktab58.data.models.enums.OrderStatus;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn
    private Expert expert;
    @ManyToOne
    @JoinColumn(nullable = false)
    private SubService subService;
    @Column(nullable = false)
    private String details;
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;
    @OneToMany(mappedBy = "order")
    private List<Offer> offers = new ArrayList<>();
    @OneToMany(mappedBy = "order")
    private List<Comment> comments;
    @ManyToOne
    private Address address;
    @Temporal(TemporalType.DATE)
    private Date requestedDate;
    private long OfferedPriceByCustomer;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
