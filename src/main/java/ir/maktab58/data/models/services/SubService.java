package ir.maktab58.data.models.services;

import ir.maktab58.data.models.ExpertSubService;
import ir.maktab58.data.models.users.Expert;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    /*@ManyToMany(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinTable(
            name = "subservice_expert",
            joinColumns = { @JoinColumn(name = "subServices_id") },
            inverseJoinColumns = { @JoinColumn(name = "expertList_id") }
    )
    private Set<Expert> expertList = new HashSet<>();*/
}
