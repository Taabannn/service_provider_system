package ir.maktab58.data.dao;

import ir.maktab58.data.models.Order;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface OrderDao extends PagingAndSortingRepository<Order, Integer> {

}
