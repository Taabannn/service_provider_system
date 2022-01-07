package ir.maktab58.data.models;

import ir.maktab58.data.models.users.Expert;
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
    @OneToOne
    private Expert expert;
    @CreationTimestamp
    private Date createdDate;
    private long offeredPrice;
    private int numOfEstimatedHours;
    @Temporal(TemporalType.TIME)
    private Date timeOfBeginning;
    @ManyToOne
    private Order order;
}
