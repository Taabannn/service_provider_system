package ir.maktab58.service.impl;

import ir.maktab58.data.repository.ManagerRepository;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.data.entities.users.Manager;
import ir.maktab58.dto.users.ManagerDto;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.interfaces.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerRepository managerDao;

    @Autowired
    ExpertServiceImpl expertService;

    @Autowired
    CustomerServiceImpl customerService;

    @Override
    public Manager managerLogin(ManagerDto managerDto) {
        Optional<Manager> foundedManager = managerDao.findManagerByUsernameAndPassword(managerDto.getUsername(), managerDto.getPassword());
        if (foundedManager.isEmpty())
            throw ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        return foundedManager.get();
    }

    @Override
    public void updateUserStatus(Manager manager, Expert expert, UserStatus newUserStatus) {
        expertService.updateExpertStatus(expert, newUserStatus);
    }

    @Override
    public void updateUserStatus(Manager manager, Customer customer, UserStatus newUserStatus) {
        customerService.updateCustomerStatus(customer, newUserStatus);
    }

    @Override
    public Manager saveNewManager(Manager manager) {
        return managerDao.save(manager);
    }
}
