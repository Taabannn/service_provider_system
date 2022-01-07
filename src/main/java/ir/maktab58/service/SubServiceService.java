package ir.maktab58.service;

import ir.maktab58.data.dao.ExpertDao;
import ir.maktab58.data.dao.SubServiceDao;
import ir.maktab58.data.models.services.MainService;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Taban Soleymani
 */
@Service
public class SubServiceService {
    @Autowired
    private SubServiceDao subServiceDao;

    @Autowired
    private ExpertDao expertDao;

    public void addASubServiceToExpert(String username, String password, String subServiceDescription, String field, long basePrice) {

        SubService subService = SubService.builder()
                .withMainService(MainService.builder().withField(field).build())
                .withSubServiceDescription(subServiceDescription)
                .withBasePrice(basePrice).build();
        subServiceDao.save(subService);

        //subServices = subServiceDao.findSubService(subServiceDescription, field);
        expertDao.addSubServiceToExpert(username, password, subService);
    }
}
