package ir.maktab58.service;

import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;

import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface ExpertService {
    Expert expertLogin(String username, String password);

    void changeExpertPassword(Expert expert, String newPassword);

    Expert saveNewExpert(Expert expert);

    void addNewSubServiceToExpertsSubServiceList(Expert expert, String subServiceDescription);

    void removeASubServiceFromExpertsServiceList(Expert expert, String subServiceDescription);

    List<Expert> getAllExpertByExpertStatus(UserStatus userStatus);

    List<Expert> getListOfExpertsBySubService(String subServiceDescription);

    void updateExpertStatus(Expert expert, UserStatus newUserStatus);

    void checkIfExpertHasSubService(SubService subService, Expert expert);
}
