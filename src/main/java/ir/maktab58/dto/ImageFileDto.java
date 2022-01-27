package ir.maktab58.dto;

import ir.maktab58.data.enums.ImageType;
import ir.maktab58.dto.users.ExpertDto;
import lombok.*;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class ImageFileDto {
    private String name;

    private ImageType type;

    private byte[] image;

    private ExpertDto expert;
}
