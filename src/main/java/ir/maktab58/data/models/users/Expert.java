package ir.maktab58.data.models.users;

import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Taban Soleymani
 */
@Entity
@DiscriminatorValue(value = "expert")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    private double score = 0.0;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SubService> subServices = new ArrayList<>();
    @Lob
    private byte[] image;

    @Builder(setterPrefix = "with")
    public Expert(int id, String username, String password, String email, Date firstAccess, UserStatus userStatus, double score, byte[] image) {
        super(id, username, password, email, firstAccess);
        this.userStatus = userStatus;
        this.score = score;
        this.image = image;
    }
}
