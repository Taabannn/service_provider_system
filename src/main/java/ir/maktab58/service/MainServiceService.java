package ir.maktab58.service;

import ir.maktab58.data.models.services.MainService;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
public interface MainServiceService {
    MainService saveNewMainService(String field);

}
