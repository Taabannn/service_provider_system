package ir.maktab58.data.entities;

import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.data.enums.ImageType;
import lombok.*;

import javax.persistence.*;

/**
 * @author Taban Soleymani
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(setterPrefix = "with")
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ImageType type = ImageType.PROFILE;

    @Lob
    private byte[] data;

    @ManyToOne
    private Expert expert;
}
