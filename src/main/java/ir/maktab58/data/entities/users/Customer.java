package ir.maktab58.data.entities.users;

import ir.maktab58.data.entities.CustomerAddress;
import ir.maktab58.data.entities.Wallet;
import ir.maktab58.data.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Taban Soleymani
 */
@Entity
@DiscriminatorValue(value = "customer")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"userStatus"})
@ToString(callSuper = true)
public class Customer extends User {
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToMany(mappedBy = "customer")
    private Set<CustomerAddress> customerAddressSet;

    @Builder(setterPrefix = "with")
    public Customer(int id, String firstName, String lastName, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, Wallet wallet, Set<CustomerAddress> customerAddressSet) {
        super(id, firstName, lastName, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.wallet = wallet;
        this.customerAddressSet = customerAddressSet;
    }
}
