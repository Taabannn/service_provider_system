package ir.maktab58.data.dao;

import ir.maktab58.config.DataBaseConfig;
import ir.maktab58.data.dto.ExpertDTO;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.data.utils.SessionUtil;
import ir.maktab58.exceptions.ServiceSysException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * @author Taban Soleymani
 */
@Repository
@RequiredArgsConstructor
//@Component
public class ExpertDao extends BaseDaoImpl<Expert> {
    @Autowired
    private SessionFactory sessionFactory;

    public Expert findExpertByUserAndPass(String username, String password) {
        Expert expert;
        try {
            Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
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

    public void addSubServiceToExpert(String username, String password, SubService subService) {
        Expert expert;
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query<Expert> query = session.createQuery("from Expert e where e.username=:username and e.password=:password", Expert.class)
                    .setParameter("username", username)
                    .setParameter("password", password);
            expert = query.getSingleResult();
            expert.getSubServices().add(subService);
            transaction.commit();
            session.close();
        } catch (NoResultException e) {
            throw ServiceSysException.builder()
                    .withMessage("No expert with entered username and password was found.")
                    .withErrorCode(400).build();
        }
    }
}
