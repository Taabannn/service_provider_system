package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Manager;
import ir.maktab58.exceptions.ServiceSysException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface ManagerDao extends PagingAndSortingRepository<Manager, Integer> {
    /*@Autowired
    private SessionFactory sessionFactory;

    public Manager findManagerByUserAndPass(String username, String password) {
        Manager manager;
        try {
            Session session = sessionFactory.openSession();
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
    }*/
}
