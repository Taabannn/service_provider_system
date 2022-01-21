package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.services.MainService;
import ir.maktab58.dto.services.MainServiceDto;
import ir.maktab58.service.mapper.interfaces.MainServiceMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class MainServiceMapperImpl implements MainServiceMapper {
    @Override
    public MainService toMainService(MainServiceDto mainServiceDto) {
        return MainService.builder()
                .withField(mainServiceDto.getField()).build();
    }

    @Override
    public MainServiceDto toMainServiceDto(MainService mainService) {
        return MainServiceDto.builder()
                .withField(mainService.getField()).build();
    }
}
