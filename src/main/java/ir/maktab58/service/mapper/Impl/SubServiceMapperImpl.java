package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.service.mapper.interfaces.SubServiceMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class SubServiceMapperImpl implements SubServiceMapper {
    @Override
    public SubService toSubService(SubServiceDto subServiceDto) {
        return null;
    }

    @Override
    public SubServiceDto toSubServiceDto(SubService subService) {
        return null;
    }
}
