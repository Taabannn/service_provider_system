package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface UserDao extends PagingAndSortingRepository<User, Integer> {
    public Optional<User> findUserByEmail(String email);

    public Optional<User> findUserByUsername(String username);

    public Optional<User> findUserByUsernameAndPassword(String username, String password);
}
