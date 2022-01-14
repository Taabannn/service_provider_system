package ir.maktab58.service;

import ir.maktab58.data.models.users.User;

/**
 * @author Taban Soleymani
 */
public interface UserService {

    User login(String username, String password);

    void validateEmailAndUserAndPass(String username, String password, String email);

    User saveNewUser(String role, String username, String password, String email, byte[] image);

    void isUsernameOrEmailAlreadyTaken(String username, String email);
}
