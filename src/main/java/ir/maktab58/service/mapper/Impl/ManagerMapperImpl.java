package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.users.Manager;
import ir.maktab58.dto.users.ManagerDto;
import ir.maktab58.service.mapper.interfaces.ManagerMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class ManagerMapperImpl implements ManagerMapper {
    @Override
    public Manager toManager(ManagerDto managerDto) {
        return null;
    }

    @Override
    public ManagerDto toManagerDto(Manager manager) {
        return null;
    }
}
