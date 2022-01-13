package ir.maktab58.service;

import ir.maktab58.data.dao.ManagerDao;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Autowired
    ExpertServiceImpl expertService;

    @Autowired
    CustomerServiceImpl customerService;

    @Override
    public Manager managerLogin(String username, String password) {
        Optional<Manager> foundedManager = managerDao.findManagerByUsernameAndPassword(username, password);
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
