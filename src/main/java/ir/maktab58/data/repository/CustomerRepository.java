package ir.maktab58.data.repository;

import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findCustomerByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("update Customer c set c.password=:newPassword where c.username=:username and c.password=:password")
    void updateCustomerPassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);

    @Modifying
    @Query("update Customer c set c.lastUpdate=:lastUpdate where c.username=:username and c.password=:password")
    void updateCustomerLastUpdate(@Param("username") String username, @Param("password") String password, @Param("lastUpdate") Date lastUpdate);


    List<Customer> getAllByUserStatus(UserStatus userStatus);

    @Modifying
    @Query("update Customer c set c.userStatus=:newUserStatus where c.username=:username and c.password=:password")
    void updateCustomerStatus(@Param("username") String username, @Param("password") String password, @Param("newUserStatus") UserStatus newUserStatus);

    Optional<Customer> findCustomerByUsernameAndUserStatus(String username, UserStatus userStatus);

    Optional<Customer> findCustomerByUsername(String username);

    Optional<Customer> findCustomerByEmail(String email);

    @Modifying
    @Query("update Wallet w set w.wallet=:wallet where w.id=:id")
    void updateCustomerWallet(@Param("id") int id, @Param("wallet") long wallet);
}
