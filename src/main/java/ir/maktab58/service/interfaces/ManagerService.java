package ir.maktab58.service.interfaces;

import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.data.entities.users.Manager;
import ir.maktab58.dto.users.ManagerDto;

/**
 * @author Taban Soleymani
 */
public interface ManagerService {
    Manager managerLogin(ManagerDto managerDto);

    void updateUserStatus(Manager manager, Expert expert, UserStatus newUserStatus);

    void updateUserStatus(Manager manager, Customer customer, UserStatus newUserStatus);

    Manager saveNewManager(Manager manager);
}
