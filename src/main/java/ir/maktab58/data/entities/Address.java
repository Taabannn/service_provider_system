package ir.maktab58.data.entities;

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
@EqualsAndHashCode(of = "postalCode")
@Builder(setterPrefix = "with")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String alley;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String county;

    @Column(unique = true, nullable = false)
    private String postalCode;

    @OneToMany(mappedBy = "address")
    private Set<CustomerAddress> customerAddressSet;
}
