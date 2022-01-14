package ir.maktab58.service;

import ir.maktab58.data.dao.OfferDao;
import ir.maktab58.data.models.Offer;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.users.Expert;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    OfferDao offerDao;

    @Autowired
    ExpertServiceImpl expertService;

    @Autowired
    OrderServiceImpl orderService;

    @Override
    public Offer saveNewOffer(Order order, Expert expert, long offeredPrice, int numOfEstimatedHours, Date timeOfBeginning) {
        Optional<Offer> offerByExpertAndOrder = offerDao.findOfferByExpertAndOrder(expert, order);
        if (offerByExpertAndOrder.isPresent())
            throw ServiceSysException.builder()
                    .withMessage("You've already sent an offer for this order. If you want to change anything please edit it.")
                    .withErrorCode(400).build();

        if (order.getExpert() != null)
            throw ServiceSysException.builder()
                .withMessage("You can't send an offer for this order because it already has an expert.")
                .withErrorCode(400).build();

        expertService.checkIfExpertHasSubService(order.getSubService(), expert);

        Offer offer = Offer.builder()
                .withExpert(expert)
                .withOfferedPrice(offeredPrice)
                .withCreatedDate(new Date())
                .withNumOfEstimatedHours(numOfEstimatedHours)
                .withOrder(order)
                .withTimeOfBeginning(timeOfBeginning).build();

        orderService.updateOrderStatusToWaitingForCustomerChoice(order);

        return offerDao.save(offer);
    }
}
