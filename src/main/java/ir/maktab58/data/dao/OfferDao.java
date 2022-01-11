package ir.maktab58.data.dao;

import ir.maktab58.data.models.Offer;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface OfferDao extends PagingAndSortingRepository<Offer, Integer> {

}
