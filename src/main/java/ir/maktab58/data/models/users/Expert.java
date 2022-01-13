package ir.maktab58.data.models.users;

import ir.maktab58.data.models.ExpertSubService;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;
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
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    private Double score;
    @OneToMany(mappedBy = "expert")
    Set<ExpertSubService> expertSubServices;
    /*@ManyToMany(mappedBy = "expertList")
    private Set<SubService> subServices = new HashSet<>();*/
    @Lob
    @Column(columnDefinition = "BLOB", length = 307200)
    private byte[] image;

    @Builder(setterPrefix = "with")
    public Expert(int id, String username, String password, String email, Date firstAccess, Date lastUpdate, UserStatus userStatus, Double score, byte[] image) {
        super(id, username, password, email, firstAccess, lastUpdate);
        this.userStatus = userStatus;
        this.score = score;
        this.image = image;
    }
}
