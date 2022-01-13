package ir.maktab58.data.dao;

import ir.maktab58.data.dto.ExpertDTO;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.exceptions.ServiceSysException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface ExpertDao extends PagingAndSortingRepository<Expert, Integer> {
    Optional<Expert> findExpertByUsernameAndPassword(String username, String password);

    @Modifying
    @Query("update Expert e set e.password=:newPassword where e.username=:username and e.password=:password")
    void updateExpertPassword(@Param("username") String username, @Param("password") String password, @Param("newPassword") String newPassword);

    List<Expert> getAllByUserStatus(UserStatus userStatus);

    @Modifying
    @Query("update Expert e set e.userStatus=:newUserStatus where e.username=:username and e.password=:password")
    void updateExpertStatus(@Param("username") String username, @Param("password") String password, @Param("newUserStatus") UserStatus newUserStatus);

    /*@Query("select e from Expert e join ExpertSubService exsub where exsub.subService.subServiceDescription=:subServiceDescription and exsub.expert.userId=e.userId")
    List<Expert> getExpertsBySubService(@Param("subServiceDescription") String subServiceDescription);
    *//*@Autowired
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
    }*/
}
