package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.ExpertSubService;
import ir.maktab58.dto.ExpertSubServiceDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface ExpertSubServiceMapper {
    ExpertSubService toExpertSubService(ExpertSubServiceDto expertSubServiceDto);

    ExpertSubServiceDto toExpertServiceDto(ExpertSubService expertSubService);
}
