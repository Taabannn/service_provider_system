package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.users.Manager;
import ir.maktab58.dto.users.ManagerDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface ManagerMapper {
    Manager toManager(ManagerDto managerDto);

    ManagerDto toManagerDto(Manager manager);
}
