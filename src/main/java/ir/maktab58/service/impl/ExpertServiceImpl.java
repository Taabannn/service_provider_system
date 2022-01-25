package ir.maktab58.service.impl;

import ir.maktab58.data.repository.ExpertRepository;
import ir.maktab58.data.repository.ExpertSubServiceRepository;
import ir.maktab58.data.repository.SubServiceRepository;
import ir.maktab58.data.entities.ExpertSubService;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.exceptions.DuplicateUserException;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.interfaces.ExpertService;
import ir.maktab58.service.mapper.Impl.SubServiceMapperImpl;
import ir.maktab58.service.mapper.interfaces.ExpertMapper;
import ir.maktab58.service.mapper.interfaces.SubServiceMapper;
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
    private ExpertRepository expertRepository;

    @Autowired
    private SubServiceRepository subServiceDao;

    @Autowired
    private ExpertSubServiceRepository expertSubServiceRepository;

    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private SubServiceMapperImpl subServiceMapper;

    @Override
    public Expert expertLogin(ExpertDto expertDto) {
        Optional<Expert> foundedExpert = expertRepository.findExpertByUsernameAndPassword(expertDto.getUsername(), expertDto.getPassword());
        if (foundedExpert.isEmpty())
            throw  ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        return foundedExpert.get();
    }

    @Override
    public void changeExpertPassword(ExpertDto expertDto, String newPassword) {
        expertRepository.updateExpertPassword(expertDto.getUsername(), expertDto.getPassword(), newPassword);
        expertRepository.updateExpertLastUpdate(expertDto.getUsername(), newPassword, new Date());
    }

    @Override
    public Expert saveNewExpert(Expert expert) {
        return expertRepository.save(expert);
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
        Optional<ExpertSubService> expertSubService = expertSubServiceRepository.findExpertSubServiceByExpertAndSubService(expert, subService);
        if (expertSubService.isPresent()) {
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " has already added to your services list.")
                    .withErrorCode(400).build();
        }

        ExpertSubService newExpertSubService = ExpertSubService.builder()
                .withSubService(subService)
                .withExpert(expert)
                .withCreationDate(new Date()).build();
        expertSubServiceRepository.save(newExpertSubService);
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
        List<ExpertSubService> expertSubs = expertSubServiceRepository.findExpertSubServiceBySubService(subService);
        if (expertSubs.size() == 0) {
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " has not existed in your services list.")
                    .withErrorCode(400).build();
        }
        expertSubServiceRepository.deleteByExpertAndSubService(expert, subService);
    }

    @Override
    public List<Expert> getAllExpertByExpertStatus(UserStatus userStatus) {
        return expertRepository.getAllByUserStatus(userStatus);
    }

    @Override
    public List<Expert> getListOfExpertsBySubService(String subServiceDescription) {
        List<ExpertSubService> expertSubByDescription = expertSubServiceRepository.findExpertSubServiceBySubServiceDescription(subServiceDescription);
        return expertSubByDescription.stream().map(ExpertSubService::getExpert).collect(Collectors.toList());
    }

    @Override
    public void updateExpertStatus(Expert expert, UserStatus newUserStatus) {
        expertRepository.updateExpertStatus(expert.getUsername(), expert.getPassword(), newUserStatus);
    }

    @Override
    public void checkIfExpertHasSubService(SubService subService, Expert expert) {
        List<ExpertSubService> expertSubServices = expertSubServiceRepository.findExpertSubServiceBySubService(subService);
        List<Expert> experts = expertSubServices.stream().map(ExpertSubService::getExpert).collect(Collectors.toList());
        if (!experts.contains(expert))
            throw ServiceSysException.builder()
                    .withMessage("Expert has not been added in SubService.")
                    .withErrorCode(400).build();
    }

    public Optional<Expert> findVerifiedExpertByUsername(String username) {
        return expertRepository.findExpertByUsernameAndUserStatus(username, UserStatus.VERIFIED);
    }

    public Expert expertSignUp(ExpertDto expertDto) {
        Optional<Expert> expertByUsername = expertRepository.findExpertByUsername(expertDto.getUsername());
        Optional<Expert> expertByEmail = expertRepository.findExpertByEmail(expertDto.getEmail());

        if (expertByEmail.isPresent())
            throw new DuplicateUserException("This email has been existed.", 400);

        if (expertByUsername.isPresent())
            throw new DuplicateUserException("This username has been existed.", 400);

        Expert expert = expertMapper.toExpert(expertDto);
        expert.setFirstAccess(new Date());
        expert.setUserStatus(UserStatus.NEW);
        return expertRepository.save(expert);
    }

    public List<SubServiceDto> getSubServiceListByExpert(Expert expert) {
        List<ExpertSubService> serviceByExpert = expertSubServiceRepository.findExpertSubServiceByExpert(expert);
        List<SubService> serviceList = serviceByExpert.stream().map(ExpertSubService::getSubService).collect(Collectors.toList());
        return serviceList.stream().map(subServiceMapper::toSubServiceDto).collect(Collectors.toList());
    }
}
