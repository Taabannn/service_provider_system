package ir.maktab58.data.dao;

import ir.maktab58.data.models.Order;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Taban Soleymani
 */
//@Component
@Repository
@RequiredArgsConstructor
public class OrderDao extends BaseDaoImpl<Order> {
    @Autowired
    private SessionFactory sessionFactory;
}
