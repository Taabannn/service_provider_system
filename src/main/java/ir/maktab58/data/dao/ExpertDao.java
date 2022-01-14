package ir.maktab58.data.dao;

import ir.maktab58.data.dto.ExpertDTO;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.exceptions.ServiceSysException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface ExpertDao extends PagingAndSortingRepository<Expert, Integer> {
    Optional<Expert> findExpertByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("update Expert e set e.password=:newPassword where e.username=:username and e.password=:password")
    void updateExpertPassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);

    List<Expert> getAllByUserStatus(UserStatus userStatus);

    @Modifying
    @Query("update Expert e set e.userStatus=:newUserStatus where e.username=:username and e.password=:password")
    void updateExpertStatus(@Param("username") String username, @Param("password") String password, @Param("newUserStatus") UserStatus newUserStatus);

    Optional<Expert> findExpertByUsernameAndUserStatus(String username, UserStatus userStatus);
}
