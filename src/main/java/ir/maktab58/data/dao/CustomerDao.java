package ir.maktab58.data.dao;

import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
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
public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer> {

    Optional<Customer> findCustomerByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("update Customer c set c.password=:newPassword where c.username=:username and c.password=:password")
    void updateCustomerPassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);

    List<Customer> getAllByUserStatus(UserStatus userStatus);

    @Modifying
    @Query("update Customer c set c.userStatus=:newUserStatus where c.username=:username and c.password=:password")
    void updateCustomerStatus(@Param("username") String username, @Param("password") String password, @Param("newUserStatus") UserStatus newUserStatus);
}
