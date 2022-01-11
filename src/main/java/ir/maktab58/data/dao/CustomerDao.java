package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface CustomerDao extends PagingAndSortingRepository<Customer, Integer> {
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
