package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.ImageFile;
import ir.maktab58.dto.ImageFileDto;
import ir.maktab58.service.mapper.interfaces.ImageFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class ImageFileMapperImpl implements ImageFileMapper {
    @Autowired
    private ExpertMapperImpl expertMapper;

    @Override
    public ImageFile toImageFile(ImageFileDto imageFileDto) {
        return ImageFile.builder()
                .withImage(imageFileDto.getImage())
                .withExpert(expertMapper.toExpert(imageFileDto.getExpert()))
                .withName(imageFileDto.getName())
                .withType(imageFileDto.getType()).build();
    }

    @Override
    public ImageFileDto toImageFileDto(ImageFile imageFile) {
        return ImageFileDto.builder()
                .withImage(imageFile.getImage())
                .withExpert(expertMapper.toExpertDto(imageFile.getExpert()))
                .withName(imageFile.getName())
                .withType(imageFile.getType()).build();
    }
}
