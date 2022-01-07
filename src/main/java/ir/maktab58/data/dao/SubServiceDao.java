package ir.maktab58.data.dao;

import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Taban Soleymani
 */
@Component
public class SubServiceDao extends BaseDaoImpl<SubService> {
    public List<SubService> findSubService(String subServiceDescription, String field) {
        List<SubService> subServiceList;
        Session session = SessionUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("from SubService s where s.subServiceDescription=:des and s.mainService.field=:field", SubService.class)
                .setParameter("des", subServiceDescription)
                .setParameter("field", field);
        subServiceList = query.getResultList();
        transaction.commit();
        session.close();
        return subServiceList;
    }
}
