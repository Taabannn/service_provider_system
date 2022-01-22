package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.ExpertSubService;
import ir.maktab58.dto.ExpertSubServiceDto;
import ir.maktab58.service.mapper.interfaces.ExpertSubServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class ExpertSubServiceMapperImpl implements ExpertSubServiceMapper {
    @Autowired
    private ExpertMapperImpl expertMapper;

    @Autowired
    private SubServiceMapperImpl subServiceMapper;

    @Override
    public ExpertSubService toExpertSubService(ExpertSubServiceDto expertSubServiceDto) {
        return ExpertSubService.builder()
                .withExpert(expertMapper.toExpert(expertSubServiceDto.getExpertDto()))
                .withSubService(subServiceMapper.toSubService(expertSubServiceDto.getSubServiceDto()))
                .withCreationDate(expertSubServiceDto.getCreationDate()).build();
    }

    @Override
    public ExpertSubServiceDto toExpertServiceDto(ExpertSubService expertSubService) {
        return ExpertSubServiceDto.builder()
                .withExpertDto(expertMapper.toExpertDto(expertSubService.getExpert()))
                .withCreationDate(expertSubService.getCreationDate())
                .withSubServiceDto(subServiceMapper.toSubServiceDto(expertSubService.getSubService())).build();
    }
}
