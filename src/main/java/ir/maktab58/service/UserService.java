package ir.maktab58.service;

import ir.maktab58.data.dto.CustomerDTO;
import ir.maktab58.data.dto.ExpertDTO;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.models.users.Manager;
import ir.maktab58.data.models.users.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface UserService {

    User login(String username, String password);

    void validateEmailAndUserAndPass(String username, String password, String email);

    User saveNewUser(String role, String username, String password, String email, byte[] image);

    void isUsernameOrEmailAlreadyTaken(String username, String email);
}
