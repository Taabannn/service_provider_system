package ir.maktab58.data.entities;

import ir.maktab58.data.enums.OrderStatus;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.data.entities.users.Expert;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Taban Soleymani
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"trackingCode"})
@Builder(setterPrefix = "with")
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
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    private Address address;

    @Temporal(TemporalType.DATE)
    private Date requestedDate;

    private long OfferedPriceByCustomer;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false, unique = true)
    private long trackingCode;
}
