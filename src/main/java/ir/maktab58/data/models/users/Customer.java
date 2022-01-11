package ir.maktab58.data.models.users;

import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Taban Soleymani
 */
@Entity
@DiscriminatorValue(value = "customer")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Customer extends User {
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    private long credit;
    @OneToMany
    private List<Address> addressList = new ArrayList<>();

    @Builder(setterPrefix = "with")
    public Customer(int id, String username, String password, String email, Date firstAccess, UserStatus userStatus, long credit) {
        super(id, username, password, email, firstAccess);
        this.userStatus = userStatus;
        this.credit = credit;
    }
}
