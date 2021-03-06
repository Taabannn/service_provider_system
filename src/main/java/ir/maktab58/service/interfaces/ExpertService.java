package ir.maktab58.service.interfaces;

import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Expert;
import ir.maktab58.dto.users.ExpertDto;

import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface ExpertService {
    Expert expertLogin(ExpertDto expertDto);

    void changeExpertPassword(ExpertDto expertDto, String newPassword);

    Expert saveNewExpert(Expert expert);

    void addNewSubServiceToExpertsSubServiceList(Expert expert, String subServiceDescription);

    void removeASubServiceFromExpertsServiceList(Expert expert, String subServiceDescription);

    List<Expert> getAllExpertByExpertStatus(UserStatus userStatus);

    List<Expert> getListOfExpertsBySubService(String subServiceDescription);

    void updateExpertStatus(Expert expert, UserStatus newUserStatus);

    void checkIfExpertHasSubService(SubService subService, Expert expert);
}
