package ir.maktab58.data.models;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Address address;
    @OneToOne
    private Expert expert;
    private long offeredPrice;
    private String details;
    @CreationTimestamp
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;
    @OneToMany(mappedBy = "order")
    private List<Offer> offers = new ArrayList<>();
    @OneToOne
    private Comment comment;
    private int estimatedTime;
}
