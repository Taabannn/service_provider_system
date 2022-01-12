package ir.maktab58.service;

import ir.maktab58.data.dao.CustomerDao;
import ir.maktab58.data.dao.ExpertDao;
import ir.maktab58.data.dao.ManagerDao;
import ir.maktab58.data.dao.UserDao;
import ir.maktab58.data.dto.CustomerDTO;
import ir.maktab58.data.dto.ExpertDTO;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.data.models.users.User;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.validator.EmailValidator;
import ir.maktab58.service.validator.UserAndPassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        Optional<User> foundedUser = userDao.findUserByUsernameAndPassword(username, password);
        if (foundedUser.isEmpty())
            throw  ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        User user = foundedUser.get();
        if (user instanceof Manager) {
            Manager manager = (Manager) user;
            return manager;
        }
        else if (user instanceof Expert) {
            Expert expert = (Expert) user;
            return expert;
        }
        else if (user instanceof Customer) {
            Customer customer = (Customer) user;
            return customer;
        }
        else
            return null;
    }

    /*@Autowired
    private CustomerDao customerDao;

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private ExpertDao expertDao;

    public void validateEmailAndUserAndPass(String username, String password, String email) {
        boolean emailValid = EmailValidator.getInstance().isEmailValid(email);
        boolean userAndPassValid = UserAndPassValidator.getInstance().isUserAndPassValid(username, password);

        if (!emailValid)
            throw ServiceSysException.builder()
                    .withMessage("Entered email is not valid.")
                    .withErrorCode(400).build();

        if (!userAndPassValid)
            throw ServiceSysException.builder()
                    .withMessage("Entered username or password is not valid.")
                    .withErrorCode(400).build();
    }

    public void checkIfUserIsManagerOrNot(String username, String password) {
        managerDao.findManagerByUserAndPass(username, password);
    }

    public void saveManager(Manager manager) {
        try {
            managerDao.save(manager);
        } catch (RuntimeException e) {
            throw ServiceSysException.builder()
                    .withMessage("This user might have been existed")
                    .withErrorCode(400).build();
        }
    }

    public void checkIfUserIsExpertOrNot(String username, String password) {
        expertDao.findExpertByUserAndPass(username, password);
    }

    public void saveExpert(Expert expert) {
        try {
            expertDao.save(expert);
        } catch (RuntimeException e) {
            throw ServiceSysException.builder()
                    .withMessage("This user might have been existed")
                    .withErrorCode(400).build();
        }
    }

    public void checkIfUserIsCustomerOrNot(String username, String password) {
        customerDao.findCustomerByUserAndPass(username, password);
    }

    public void saveCustomer(Customer customer) {
        try {
            customerDao.save(customer);
        } catch (RuntimeException e) {
            throw ServiceSysException.builder()
                    .withMessage("This user might have been existed")
                    .withErrorCode(400).build();
        }
    }

    public List<CustomerDTO> getListOfCustomersToManager(String username, String password) {
        checkIfUserIsManagerOrNot(username, password);
        return customerDao.getListOfCustomers();
    }

    public List<ExpertDTO> getListOfExpertsToManager(String username, String password) {
        checkIfUserIsManagerOrNot(username, password);
        return expertDao.getListOfExperts();
    }*/
}
