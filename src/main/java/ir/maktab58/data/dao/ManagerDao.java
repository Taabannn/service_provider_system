package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Manager;
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
public class ManagerDao extends BaseDaoImpl<Manager> {
    public Manager findManagerByUserAndPass(String username, String password) {
        Manager manager;
        try {
            Session session = SessionUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query<Manager> query = session.createQuery("from Manager m where m.username=:username and m.password=:password", Manager.class)
                    .setParameter("username", username)
                    .setParameter("password", password);
            manager = query.getSingleResult();
            transaction.commit();
            session.close();
        } catch (NoResultException e) {
            throw ServiceSysException.builder()
                    .withMessage("No manager with entered username and password was found.")
                    .withErrorCode(400).build();
        }
        return manager;
    }
}
