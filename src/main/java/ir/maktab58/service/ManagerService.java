package ir.maktab58.service;

import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
public interface ManagerService {
    Manager managerLogin(String username, String password);

    void updateUserStatus(Manager manager, Expert expert, UserStatus newUserStatus);

    void updateUserStatus(Manager manager, Customer customer, UserStatus newUserStatus);

    Manager saveNewManager(Manager manager);
}
