package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.ImageFile;
import ir.maktab58.dto.ImageFileDto;
import ir.maktab58.service.mapper.interfaces.ImageFileMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class ImageFileMapperImpl implements ImageFileMapper {
    @Override
    public ImageFile toImageFile(ImageFileDto imageFileDto) {
        return null;
    }

    @Override
    public ImageFileDto toImageFileDto(ImageFile imageFile) {
        return null;
    }
}
