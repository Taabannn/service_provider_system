package ir.maktab58.service;

import ir.maktab58.data.models.services.SubService;

/**
 * @author Taban Soleymani
 */
public interface SubServiceService {
    SubService saveASubService(String field, String subServiceDescription, long basePrice);
}
