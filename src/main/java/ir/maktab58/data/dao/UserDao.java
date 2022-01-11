package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface UserDao extends PagingAndSortingRepository<User, Integer> {
}
