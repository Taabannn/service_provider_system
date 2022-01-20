package ir.maktab58.data.repository;

import ir.maktab58.data.entities.users.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface ManagerDao extends PagingAndSortingRepository<Manager, Integer> {
    Optional<Manager> findManagerByUsernameAndPassword(String username, String password);
}
