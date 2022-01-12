package ir.maktab58.service;

import ir.maktab58.data.dao.ExpertDao;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.User;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertDao expertDao;

    @Override
    public Expert expertLogin(String username, String password) {
        Optional<Expert> foundedExpert = expertDao.findExpertByUsernameAndPassword(username, password);
        if (foundedExpert.isEmpty())
            throw  ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        return foundedExpert.get();
    }

    @Override
    public void changeExpertPassword(Expert expert, String newPassword) {
        expertDao.updateExpertPassword(expert.getUsername(), expert.getPassword(), newPassword);
    }

    @Override
    public Expert saveNewExpert(Expert expert) {
        return expertDao.save(expert);
    }
}
