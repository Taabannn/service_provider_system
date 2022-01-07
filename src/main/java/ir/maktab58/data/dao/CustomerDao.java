package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.utils.SessionUtil;
import ir.maktab58.exceptions.ServiceSysException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

/**
 * @author Taban Soleymani
 */
@Component
public class CustomerDao extends BaseDaoImpl<Customer> {
    public Customer findCustomerByUserAndPass(String username, String password) {
        Customer customer;
        try {
            Session session = SessionUtil.getSession();
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
}
