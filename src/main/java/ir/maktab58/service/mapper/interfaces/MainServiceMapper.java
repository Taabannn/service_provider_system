package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.services.MainService;
import ir.maktab58.dto.services.MainServiceDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface MainServiceMapper {
    MainService toMainService(MainServiceDto mainServiceDto);

    MainServiceDto toMainServiceDto(MainService mainService);
}
