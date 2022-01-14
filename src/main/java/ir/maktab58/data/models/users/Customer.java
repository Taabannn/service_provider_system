package ir.maktab58.data.models.users;

import ir.maktab58.data.models.CustomerAddress;
import ir.maktab58.data.models.enums.UserStatus;
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
    private long credit;
    @OneToMany(mappedBy = "customer")
    private Set<CustomerAddress> customerAddressSet;

    @Builder(setterPrefix = "with")
    public Customer(int id, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, long credit) {
        super(id, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.credit = credit;
    }
}
