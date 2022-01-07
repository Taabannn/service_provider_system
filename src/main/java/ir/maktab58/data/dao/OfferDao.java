package ir.maktab58.data.dao;

import ir.maktab58.data.models.Offer;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Taban Soleymani
 */
@Repository
@RequiredArgsConstructor
//@Component
public class OfferDao extends BaseDaoImpl<Offer> {
    @Autowired
    private SessionFactory sessionFactory;

}
