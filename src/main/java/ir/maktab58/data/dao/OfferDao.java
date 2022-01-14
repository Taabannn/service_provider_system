package ir.maktab58.data.dao;

import ir.maktab58.data.models.Offer;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.users.Expert;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface OfferDao extends PagingAndSortingRepository<Offer, Integer> {
    Optional<Offer> findOfferByExpertAndOrder(Expert expert, Order order);
}
