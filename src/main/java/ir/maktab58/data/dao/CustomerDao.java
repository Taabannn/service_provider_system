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
    /*@Autowired
    private SessionFactory sessionFactory;

    public Customer findCustomerByUserAndPass(String username, String password) {
        Customer customer;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query<Customer> query = session.createQuery("from Customer c where c.username=:username and c.password=:password", Customer.class)
                    .setParameter("username", username)
                    .setParameter("password", password);
            customer = query.getSingleResult();
            transaction.commit();
            session.close();
        } catch (NoResultException e) {
            throw ServiceSysException.builder()
                    .withMessage("No customer with entered username and password was found.")
                    .withErrorCode(400).build();
        }
        return customer;
    }

    public List<CustomerDTO> getListOfCustomers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class, "c");

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("c.username").as("username"))
                .add(Projections.property("c.userStatus").as("userStatus"))
                .add(Projections.property("c.credit").as("credit"))
                .add(Projections.property("c.firstAccess").as("firstAccess"))
                .add(Projections.property("c.email").as("email"))
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CustomerDTO.class));
        List<CustomerDTO> list = criteria.list();

        transaction.commit();
        session.close();
        return list;
    }*/
}
