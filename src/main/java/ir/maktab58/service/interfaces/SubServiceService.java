package ir.maktab58.service.interfaces;

import ir.maktab58.data.entities.services.SubService;

/**
 * @author Taban Soleymani
 */
public interface SubServiceService {
    SubService saveASubService(String field, String subServiceDescription, long basePrice);
}
