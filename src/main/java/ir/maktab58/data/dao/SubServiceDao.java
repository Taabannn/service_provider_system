package ir.maktab58.data.dao;

import ir.maktab58.data.entities.services.MainService;
import ir.maktab58.data.entities.services.SubService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface SubServiceDao extends PagingAndSortingRepository<SubService, Integer> {//JPAREpo

    Optional<SubService> findBySubServiceDescriptionAndBasePriceAndMainService(String subServiceDescription, long BasePrice, MainService mainService);

    Optional<SubService> findBySubServiceDescription(String subServiceDescription);

    Optional<SubService> findSubServiceBySubServiceDescription(String subServiceDescription);
}
