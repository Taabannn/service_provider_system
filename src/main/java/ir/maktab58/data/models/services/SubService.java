package ir.maktab58.data.models.services;

import ir.maktab58.data.models.users.Expert;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Taban Soleymani
 */
@Entity
//@NamedEntityGraph(name = "SubService.detail",
//        attributeNodes = @NamedAttributeNode("mainService"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@EqualsAndHashCode
@ToString(exclude = {"expertList", "mainService"})
public class SubService {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true, nullable = false)
    private String subServiceDescription;
    @Column(nullable = false)
    private long basePrice;
    @ManyToOne(cascade = CascadeType.MERGE)
    private MainService mainService;
    @ManyToMany
    private List<Expert> expertList = new ArrayList<>();
}
