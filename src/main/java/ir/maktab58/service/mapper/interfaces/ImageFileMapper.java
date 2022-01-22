package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.ImageFile;
import ir.maktab58.dto.ImageFileDto;

/**
 * @author Taban Soleymani
 */
public interface ImageFileMapper {
    ImageFile toImageFile(ImageFileDto imageFileDto);

    ImageFileDto toImageFileDto(ImageFile imageFile);
}
