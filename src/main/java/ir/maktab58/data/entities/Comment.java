package ir.maktab58.data.entities;

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
@EqualsAndHashCode(of = "trackingCode")
@Builder(setterPrefix = "with")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private double score;

    @Column(nullable = false)
    @CreationTimestamp
    private Date createdDate;

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.MERGE)
    private Order order;

    @Column(unique = true, nullable = false)
    private long trackingCode;
}
