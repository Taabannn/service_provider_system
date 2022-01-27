package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.dto.services.SubServiceDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface SubServiceMapper {
    SubService toSubService(SubServiceDto subServiceDto);

    SubServiceDto toSubServiceDto(SubService subService);
}
