package ir.maktab58.service;

import ir.maktab58.data.dao.ExpertDao;
import ir.maktab58.data.dao.ExpertSubServiceDao;
import ir.maktab58.data.dao.SubServiceDao;
import ir.maktab58.data.models.ExpertSubService;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.User;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Taban Soleymani
 */
@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertDao expertDao;

    @Autowired
    private SubServiceDao subServiceDao;

    @Autowired
    private ExpertSubServiceDao expertSubServiceDao;

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

    @Override
    public void addNewSubServiceToExpertsSubServiceList(Expert expert, String subServiceDescription) {
        Optional<SubService> foundedSubService = subServiceDao.findBySubServiceDescription(subServiceDescription);
        if (foundedSubService.isEmpty())
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " has not added yet.\n" +
                            "Please call admin.")
                    .withErrorCode(400).build();

        SubService subService = foundedSubService.get();
        Optional<ExpertSubService> expertSubService = expertSubServiceDao.findExpertSubServiceByExpertAndSubService(expert, subService);
        if (expertSubService.isPresent()) {
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " has already added to your services list.")
                    .withErrorCode(400).build();
        }

        ExpertSubService newExpertSubService = ExpertSubService.builder()
                .withSubService(subService)
                .withExpert(expert)
                .withCreationDate(new Date()).build();
        expertSubServiceDao.save(newExpertSubService);
    }

    @Override
    public void removeASubServiceFromExpertsServiceList(Expert expert, String subServiceDescription) {
        Optional<SubService> foundedSubService = subServiceDao.findBySubServiceDescription(subServiceDescription);
        if (foundedSubService.isEmpty())
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " has not added yet.\n" +
                            "Please call admin.")
                    .withErrorCode(400).build();

        SubService subService = foundedSubService.get();
        List<ExpertSubService> expertSubs = expertSubServiceDao.findExpertSubServiceBySubService(subService);
        if (expertSubs.size() == 0) {
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " has not existed in your services list.")
                    .withErrorCode(400).build();
        }
        expertSubServiceDao.deleteByExpertAndSubService(expert, subService);
    }

    @Override
    public List<Expert> getAllExpertByExpertStatus(UserStatus userStatus) {
        return expertDao.getAllByUserStatus(userStatus);
    }

    @Override
    public List<Expert> getListOfExpertsBySubService(String subServiceDescription) {
        List<ExpertSubService> expertSubByDescription = expertSubServiceDao.findExpertSubServiceBySubServiceDescription(subServiceDescription);
        return expertSubByDescription.stream().map(ExpertSubService::getExpert).collect(Collectors.toList());
    }

    public void updateExpertStatus(Expert expert, UserStatus newUserStatus) {
        expertDao.updateExpertStatus(expert.getUsername(), expert.getPassword(), newUserStatus);
    }
}
