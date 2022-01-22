package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.service.mapper.interfaces.ExpertMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class ExpertMapperImpl implements ExpertMapper {
    @Override
    public Expert toExpert(ExpertDto expertDto) {
        return null;
    }

    @Override
    public ExpertDto toExpertDto(Expert expert) {
        return null;
    }
}
