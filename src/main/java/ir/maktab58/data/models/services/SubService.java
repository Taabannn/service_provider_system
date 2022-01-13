package ir.maktab58.data.models.services;

import ir.maktab58.data.models.ExpertSubService;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Taban Soleymani
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@EqualsAndHashCode(of = {"subServiceDescription", "basePrice"})
@ToString
public class SubService {
    @Id
    @GeneratedValue
    private int subServiceId;
    @Column(unique = true, nullable = false)
    private String subServiceDescription;
    @Column(nullable = false)
    private long basePrice;
    @ManyToOne(cascade = CascadeType.MERGE)
    private MainService mainService;
    @OneToMany(mappedBy = "subService")
    Set<ExpertSubService> expertSubServices;
}
