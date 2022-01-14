package ir.maktab58.data.models;

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
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String alley;
    private String street;
    private String city;
    private String county;
    @Column(unique = true)
    private String postalCode;
    @OneToMany(mappedBy = "address")
    private Set<CustomerAddress> customerAddressSet;
}
