package ir.maktab58.data.dao;

import ir.maktab58.data.models.ExpertSubService;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Repository
public interface ExpertSubServiceDao extends CrudRepository<ExpertSubService, Integer> {

    Optional<ExpertSubService> findExpertSubServiceByExpertAndSubService(Expert expert, SubService subService);
}
