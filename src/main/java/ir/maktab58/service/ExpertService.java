package ir.maktab58.service;

import ir.maktab58.data.models.users.Expert;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
public interface ExpertService {
    Expert expertLogin(String username, String password);

    void changeExpertPassword(Expert expert, String newPassword);

    Expert saveNewExpert(Expert expert);

    void addNewSubServiceToExpertsSubServiceList(Expert expert, String subServiceDescription);

    void removeASubServiceFromExpertsServiceList(Expert expert, String subServiceDescription);
}
