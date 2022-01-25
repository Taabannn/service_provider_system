package ir.maktab58.data.repository;

import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.users.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
    Optional<Expert> findExpertByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("update Expert e set e.password=:newPassword where e.username=:username and e.password=:password")
    void updateExpertPassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);

    List<Expert> getAllByUserStatus(UserStatus userStatus);

    @Modifying
    @Query("update Expert e set e.userStatus=:newUserStatus where e.username=:username and e.password=:password")
    void updateExpertStatus(@Param("username") String username, @Param("password") String password, @Param("newUserStatus") UserStatus newUserStatus);

    Optional<Expert> findExpertByUsernameAndUserStatus(String username, UserStatus userStatus);

    Optional<Expert> findExpertByUsername(String username);

    Optional<Expert> findExpertByEmail(String email);
}
