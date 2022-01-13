package ir.maktab58.data.dao;

import ir.maktab58.data.models.ExpertSubService;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Repository
public interface ExpertSubServiceDao extends CrudRepository<ExpertSubService, Integer> {

    Optional<ExpertSubService> findExpertSubServiceByExpertAndSubService(Expert expert, SubService subService);

    @Query("from ExpertSubService exsub join exsub.subService sub where sub.subServiceDescription=:subServiceDescription")
    List<ExpertSubService> findExpertSubServiceBySubServiceDescription(@Param("subServiceDescription") String subServiceDescription);
}
