package ir.maktab58.service;

import ir.maktab58.data.dao.CustomerDao;
import ir.maktab58.data.dao.ExpertDao;
import ir.maktab58.data.dao.ManagerDao;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.validator.EmailValidator;
import ir.maktab58.service.validator.UserAndPassValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
@Service
//@DependsOn()
public class UserService {
    @Autowired
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

    public void CheckIfUserIsManagerOrNot(String username, String password) {
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

    public void CheckIfUserIsExpertOrNot(String username, String password) {
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

    }
}
