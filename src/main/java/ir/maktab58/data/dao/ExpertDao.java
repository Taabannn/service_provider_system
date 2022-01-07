package ir.maktab58.data.dao;

import ir.maktab58.data.models.users.Expert;
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
public class ExpertDao extends BaseDaoImpl<Expert> {
    public Expert findExpertByUserAndPass(String username, String password) {
        Expert expert;
        try {
            Session session = SessionUtil.getSession();
            Transaction transaction = session.beginTransaction();
            Query<Expert> query = session.createQuery("from Expert e where e.username=:username and e.password=:password", Expert.class)
                    .setParameter("username", username)
                    .setParameter("password", password);
            expert = query.getSingleResult();
            transaction.commit();
            session.close();
        } catch (NoResultException e) {
            throw ServiceSysException.builder()
                    .withMessage("No expert with entered username and password was found.")
                    .withErrorCode(400).build();
        }
        return expert;
    }
}
