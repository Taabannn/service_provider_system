package ir.maktab58.service;

import ir.maktab58.data.dao.UserDao;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.data.models.users.User;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.validator.EmailValidator;
import ir.maktab58.service.validator.UserAndPassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ExpertServiceImpl expertService;

    @Autowired
    private ManagerServiceImpl managerService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    public User login(String username, String password) {
        Optional<User> foundedUser = userDao.findUserByUsernameAndPassword(username, password);
        if (foundedUser.isEmpty())
            throw  ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        return foundedUser.get();
    }

    @Override
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

    @Override
    public User saveNewUser(String role, String username, String password, String email, byte[] image) {
        validateEmailAndUserAndPass(username, password, email);
        isUsernameOrEmailAlreadyTaken(username, email);
        switch (role.toLowerCase()) {
            case "manager":
                Manager manager = Manager.builder()
                        .withUsername(username)
                        .withPassword(password)
                        .withEmail(email)
                        .withFirstAccess(new Date()).build();
                return managerService.saveNewManager(manager);
            case "expert":
                Expert expert = Expert.builder()
                        .withUsername(username)
                        .withPassword(password)
                        .withEmail(email)
                        .withImage(image)
                        .withUserStatus(UserStatus.NEW)
                        .withFirstAccess(new Date()).build();
                return expertService.saveNewExpert(expert);
            case "customer":
                Customer customer = Customer
                        .builder()
                        .withUsername(username)
                        .withPassword(password)
                        .withEmail(email)
                        .withCredit(0)
                        .withUserStatus(UserStatus.NEW)
                        .withFirstAccess(new Date()).build();
                return customerService.saveNewCustomer(customer);
            default: throw ServiceSysException.builder()
                    .withErrorCode(500)
                    .withMessage("Unable to save new " + role + " in user...\n" +
                            "Please try again!").build();
        }
    }

    @Override
    public void isUsernameOrEmailAlreadyTaken(String username, String email) {
        Optional<User> userByUsername = userDao.findUserByUsername(username);
        Optional<User> userByEmail = userDao.findUserByEmail(email);
        if (userByUsername.isPresent())
            throw ServiceSysException.builder()
                    .withMessage("Sorry! username " + username + " is already taken")
                    .withErrorCode(400).build();
        if (userByEmail.isPresent())
            throw ServiceSysException.builder()
                    .withMessage("Sorry! email " + email + " is already taken")
                    .withErrorCode(400).build();
    }
}
