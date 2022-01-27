package ir.maktab58.data.repository;

import ir.maktab58.data.entities.services.MainService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface MainServiceRepository extends JpaRepository<MainService, Integer> {

    Optional<MainService> findMainServiceByField(String field);
}
