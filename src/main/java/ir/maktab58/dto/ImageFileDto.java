package ir.maktab58.dto;

import ir.maktab58.data.enums.ImageType;
import ir.maktab58.dto.users.ExpertDto;

/**
 * @author Taban Soleymani
 */
public class ImageFileDto {
    private String name;

    private ImageType type;

    private byte[] image;
    
    private ExpertDto expert;
}
