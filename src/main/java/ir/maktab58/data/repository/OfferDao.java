package ir.maktab58.data.repository;

import ir.maktab58.data.entities.Offer;
import ir.maktab58.data.entities.Order;
import ir.maktab58.data.entities.users.Expert;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface OfferDao extends PagingAndSortingRepository<Offer, Integer> {
    Optional<Offer> findOfferByExpertAndOrder(Expert expert, Order order);
}
