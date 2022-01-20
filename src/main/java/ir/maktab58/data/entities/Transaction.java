package ir.maktab58.data.entities;

import ir.maktab58.data.enums.TransactionStatus;
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
@EqualsAndHashCode
@ToString
@Builder(setterPrefix = "with")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Order order;
    @CreationTimestamp
    private Date creationDate;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
}
