package ir.maktab58.data.entities;

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
@EqualsAndHashCode(of = {"image", "expert"})
@Builder(setterPrefix = "with")
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ImageType type = ImageType.PROFILE;

    @Lob
    @Column(columnDefinition = "BLOB", length = 307200, nullable = false)
    private byte[] image;}
