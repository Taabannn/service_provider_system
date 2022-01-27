package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.ImageFile;
import ir.maktab58.dto.ImageFileDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface ImageFileMapper {
    ImageFile toImageFile(ImageFileDto imageFileDto);

    ImageFileDto toImageFileDto(ImageFile imageFile);
}
