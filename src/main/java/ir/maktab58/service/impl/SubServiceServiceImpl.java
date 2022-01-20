package ir.maktab58.service.impl;

import ir.maktab58.data.repository.SubServiceDao;
import ir.maktab58.data.entities.services.MainService;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.exceptions.ServiceSysException;
import ir.maktab58.service.interfaces.SubServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class SubServiceServiceImpl implements SubServiceService {
    @Autowired
    private SubServiceDao subServiceDao;

    @Autowired
    private MainServiceServiceImpl mainServiceService;

    @Override
    public SubService saveASubService(String field, String subServiceDescription, long basePrice) {
        Optional<MainService> foundedMainService = mainServiceService.findMainServiceByField(field);
        if (foundedMainService.isPresent()) {
            MainService mainService = foundedMainService.get();
            Optional<SubService> foundedSubService = subServiceDao.findBySubServiceDescriptionAndBasePriceAndMainService(subServiceDescription, basePrice, mainService);
            checkSubServiceIsExisted(foundedSubService, subServiceDescription);
            return saveNewSubService(mainService, subServiceDescription, basePrice);
        } else {
            return saveANewMainAndSubService(field, subServiceDescription, basePrice);
        }
    }

    public SubService saveANewMainAndSubService(String field, String subServiceDescription, long basePrice) {
        MainService mainService = mainServiceService.saveNewMainService(field);
        SubService subService = SubService.builder()
                .withMainService(mainService)
                .withSubServiceDescription(subServiceDescription)
                .withBasePrice(basePrice).build();
        return subServiceDao.save(subService);
    }

    public SubService saveNewSubService(MainService mainService, String subServiceDescription, long basePrice) {
        SubService subService = SubService.builder()
                .withSubServiceDescription(subServiceDescription)
                .withMainService(mainService)
                .withBasePrice(basePrice).build();
        return subServiceDao.save(subService);
    }

    public void checkSubServiceIsExisted(Optional<SubService> foundedSubService, String subServiceDescription) {
        if (foundedSubService.isPresent()) {
            throw ServiceSysException.builder()
                    .withMessage("SubService " + subServiceDescription + " is already Existed.")
                    .withErrorCode(400).build();
        }
    }

    public Optional<SubService> findSubServiceByDescription(String description) {
        return subServiceDao.findBySubServiceDescription(description);
    }
}
