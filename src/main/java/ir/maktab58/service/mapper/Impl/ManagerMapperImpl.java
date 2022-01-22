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
        return Manager.builder()
                .withFirstName(managerDto.getFirstName())
                .withLastName(managerDto.getLastName())
                .withUsername(managerDto.getUsername())
                .withPassword(managerDto.getPassword())
                .withEmail(managerDto.getEmail())
                .withFirstAccess(managerDto.getFirstAccess())
                .withLastUpdate(managerDto.getLastUpdate())
                .build();
    }

    @Override
    public ManagerDto toManagerDto(Manager manager) {
        return ManagerDto.builder()
                .withFirstName(manager.getFirstName())
                .withLastName(manager.getLastName())
                .withUsername(manager.getUsername())
                .withPassword(manager.getPassword())
                .withEmail(manager.getEmail())
                .withFirstAccess(manager.getFirstAccess())
                .withLastUpdate(manager.getLastUpdate())
                .build();
    }
}
