package ir.maktab58.data.repository;

import ir.maktab58.data.entities.Order;
import ir.maktab58.data.enums.OrderStatus;
import ir.maktab58.data.entities.services.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findOrdersBySubService(SubService subService);

    Optional<Order> findById(Integer integer);

    @Modifying
    @Query("update Order o set o.orderStatus=:waitingForChoosingExpert where o.id=:id")
    void updateOrderStatus(@Param("waitingForChoosingExpert") OrderStatus waitingForChoosingExpert, @Param("id") int id);
}
