package ir.maktab58.data.entities.users;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Entity
@DiscriminatorValue(value = "manager")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Manager extends User {

    @Builder(setterPrefix = "with")
    public Manager(int id, String username, String password, String email, Date firstAccess, Date lastUpdate) {
        super(id, username, password, email, firstAccess, lastUpdate);
    }
}
