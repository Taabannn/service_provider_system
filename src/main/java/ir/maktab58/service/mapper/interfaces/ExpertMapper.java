package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.users.ExpertDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface ExpertMapper {
    Expert toExpert(ExpertDto expertDto);

    ExpertDto toExpertDto(Expert expert);
}
