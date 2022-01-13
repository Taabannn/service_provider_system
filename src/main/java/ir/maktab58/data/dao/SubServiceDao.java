package ir.maktab58.data.dao;

import ir.maktab58.data.models.services.MainService;
import ir.maktab58.data.models.services.SubService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface SubServiceDao extends PagingAndSortingRepository<SubService, Integer> {

    Optional<SubService> findBySubServiceDescriptionAndBasePriceAndMainService(String subServiceDescription, long BasePrice, MainService mainService);

    Optional<SubService> findBySubServiceDescription(String subServiceDescription);

    /*@Query("select s from SubService s join s.expertList e where e.username=:username")
    Set<SubService> findExpertsSubServiceList(@Param("username") String username);
*/
    /*@Autowired
    private SessionFactory sessionFactory;

    public List<SubService> findSubService(String subServiceDescription, String field) {
        List<SubService> subServiceList;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("from SubService s where s.subServiceDescription=:des and s.mainService.field=:field", SubService.class)
                .setParameter("des", subServiceDescription)
                .setParameter("field", field);
        subServiceList = query.getResultList();
        transaction.commit();
        session.close();
        return subServiceList;
    }*/
}
