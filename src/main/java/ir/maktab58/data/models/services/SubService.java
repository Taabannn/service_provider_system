package ir.maktab58.data.models.services;

import ir.maktab58.data.models.users.Expert;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taban Soleymani
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@EqualsAndHashCode
@ToString
public class SubService {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String subServiceDescription;
    @Column(nullable = false)
    private long basePrice;
    @OneToOne
    private MainService mainService;
    @ManyToMany(mappedBy = "subServices")
    private List<Expert> expertList = new ArrayList<>();
}
