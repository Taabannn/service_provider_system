package ir.maktab58.service.interfaces;

import ir.maktab58.data.entities.Offer;
import ir.maktab58.data.entities.Order;
import ir.maktab58.data.entities.users.Expert;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
public interface OfferService {
    Offer saveNewOffer(Order order, Expert expert, long offeredPrice, int numOfEstimatedHours, Date timeOfBeginning);
}
