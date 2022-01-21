package ir.maktab58.data.repository;

import ir.maktab58.data.entities.ExpertSubService;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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
public interface ExpertSubServiceRepository extends JpaRepository<ExpertSubService, Integer> {

    Optional<ExpertSubService> findExpertSubServiceByExpertAndSubService(Expert expert, SubService subService);

    @Query("from ExpertSubService exsub join exsub.subService sub where sub.subServiceDescription=:subServiceDescription")
    List<ExpertSubService> findExpertSubServiceBySubServiceDescription(@Param("subServiceDescription") String subServiceDescription);

    List<ExpertSubService> findExpertSubServiceBySubService(SubService subService);

    void deleteByExpertAndSubService(Expert expert, SubService subService);

    List<ExpertSubService> findExpertSubServicesBySubService(SubService subService);
}
