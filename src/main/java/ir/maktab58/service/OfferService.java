package ir.maktab58.service;

import ir.maktab58.data.models.Offer;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.users.Expert;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public interface OfferService {
    Offer saveNewOffer(Order order, Expert expert, long offeredPrice, int numOfEstimatedHours, Date timeOfBeginning);
}
