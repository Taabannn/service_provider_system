package ir.maktab58.data.entities;

import ir.maktab58.data.entities.users.Expert;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@ToString
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Expert expert;
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdDate;
    @Column(nullable = false)
    private long offeredPrice;
    @Column(nullable = false)
    private int numOfEstimatedHours;
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date timeOfBeginning;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(nullable = false)
    private Order order;
}
