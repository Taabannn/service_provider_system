package ir.maktab58.data.entities.users;

import ir.maktab58.data.entities.ExpertSubService;
import ir.maktab58.data.entities.Wallet;
import ir.maktab58.data.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.*;

/**
 * @author Taban Soleymani
 */
@Entity
@DiscriminatorValue(value = "expert")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, of = {"image"})
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private Double score;

    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToMany(mappedBy = "expert")
    Set<ExpertSubService> expertSubServices;

    @Builder(setterPrefix = "with")
    public Expert(int id, String firstName, String lastName, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, Double score, Wallet wallet, Set<ExpertSubService> expertSubServices) {
        super(id, firstName, lastName, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.score = score;
        this.wallet = wallet;
        this.expertSubServices = expertSubServices;
    }
}
