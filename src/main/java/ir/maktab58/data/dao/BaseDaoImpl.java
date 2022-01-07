package ir.maktab58.data.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Taban Soleymani
 */
@Repository
@RequiredArgsConstructor
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T get(Class<T> cl, Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T tElement = (T) session.get(cl, id);
        transaction.commit();
        session.close();
        return tElement;
    }

    @Override
    public int save(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int result = (int) session.save(object);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public int save(T object, String entityName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int result = (int) session.save(entityName, object);
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public void update(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(T object) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }

    @Override
    public List<T> query(String mySqlQuery, Map<String, Object> params) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(mySqlQuery);
        if (params != null) {
            params.keySet().forEach(s -> query.setParameter(s, params.get(s)));
        }
        List<T> result;
        if ((!mySqlQuery.toUpperCase().contains("DELETE"))
                && (!mySqlQuery.toUpperCase().contains("UPDATE"))
                && (mySqlQuery.toUpperCase().contains("INSERT"))) {
            result = query.list();
        } else {
            result = null;
        }
        transaction.commit();
        session.close();
        return result;
    }
}
