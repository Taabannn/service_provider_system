package ir.maktab58.service;

import ir.maktab58.data.dao.MainServiceDao;
import ir.maktab58.data.models.services.MainService;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class MainServiceServiceImpl implements MainServiceService {
    @Autowired
    private MainServiceDao mainServiceDao;

    @Override
    public MainService saveNewMainService(String field) {
        Optional<MainService> foundedMainService = mainServiceDao.findMainServiceByField(field);
        if (foundedMainService.isPresent())
            throw ServiceSysException.builder()
                    .withMessage("MainService in field : " + field + " is already existed.\n" +
                        "You can add whatever subService that you want.")
                    .withErrorCode(400).build();
        MainService mainService = MainService.builder()
                .withField(field).build();
        return mainServiceDao.save(mainService);
    }
}
