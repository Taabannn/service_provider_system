package ir.maktab58.data.dao;

import ir.maktab58.data.dto.CustomerDTO;
import ir.maktab58.data.dto.ExpertDTO;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.utils.SessionUtil;
import ir.maktab58.exceptions.ServiceSysException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.util.List;

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

    public List<ExpertDTO> getListOfExperts() {
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Expert.class, "e");

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("e.username").as("username"))
                .add(Projections.property("e.userStatus").as("userStatus"))
                .add(Projections.property("e.firstAccess").as("firstAccess"))
                .add(Projections.property("e.email").as("email"))
                .add(Projections.property("e.score").as("score"))
        );

        criteria.setResultTransformer(Transformers.aliasToBean(ExpertDTO.class));
        List<ExpertDTO> list = criteria.list();

        transaction.commit();
        session.close();
        return list;
    }
}
