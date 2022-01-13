package ir.maktab58.data.models;

import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ExpertSubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*@EmbeddedId
    ExpertSubServiceKey expertServiceKey;*/

    @ManyToOne
    @JoinColumn(name = "subService_id")
    SubService subService;

    @ManyToOne
    @JoinColumn(name = "expert_id")
    Expert expert;

    @Temporal(TemporalType.DATE)
    Date creationDate;
}
