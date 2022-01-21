package ir.maktab58.service.impl;

import ir.maktab58.data.repository.ExpertRepository;
import ir.maktab58.data.repository.ExpertSubServiceRepository;
import ir.maktab58.data.repository.SubServiceRepository;
import ir.maktab58.data.entities.ExpertSubService;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.interfaces.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Taban Soleymani
 */
@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertRepository expertDao;

    @Autowired
    private SubServiceRepository subServiceDao;

    @Autowired
    private ExpertSubServiceRepository expertSubServiceDao;

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

    @Override
    public void updateExpertStatus(Expert expert, UserStatus newUserStatus) {
        expertDao.updateExpertStatus(expert.getUsername(), expert.getPassword(), newUserStatus);
    }

    @Override
    public void checkIfExpertHasSubService(SubService subService, Expert expert) {
        List<ExpertSubService> expertSubServices = expertSubServiceDao.findExpertSubServiceBySubService(subService);
        List<Expert> experts = expertSubServices.stream().map(ExpertSubService::getExpert).collect(Collectors.toList());
        if (!experts.contains(expert))
            throw ServiceSysException.builder()
                    .withMessage("Expert has not been added in SubService.")
                    .withErrorCode(400).build();
    }

    public Optional<Expert> findVerifiedExpertByUsername(String username) {
        return expertDao.findExpertByUsernameAndUserStatus(username, UserStatus.VERIFIED);
    }
}
