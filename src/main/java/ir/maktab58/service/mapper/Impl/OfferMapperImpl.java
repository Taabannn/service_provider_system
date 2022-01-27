package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Offer;
import ir.maktab58.dto.OfferDto;
import ir.maktab58.service.mapper.interfaces.OfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class OfferMapperImpl implements OfferMapper {
    @Autowired
    private ExpertMapperImpl expertMapper;

    @Autowired
    private OrderMapperImpl orderMapper;

    @Override
    public Offer toOffer(OfferDto offerDto) {
        return Offer.builder()
                .withExpert(expertMapper.toExpert(offerDto.getExpert()))
                .withCreatedDate(offerDto.getCreatedDate())
                .withOfferedPrice(offerDto.getOfferedPrice())
                .withNumOfEstimatedHours(offerDto.getNumOfEstimatedHours())
                .withTimeOfBeginning(offerDto.getTimeOfBeginning())
                .withOrder(orderMapper.toOrder(offerDto.getOrder()))
                .withOfferStatus(offerDto.getOfferStatus())
                .withTrackingCode(offerDto.getTrackingCode()).build();
    }

    @Override
    public OfferDto toOfferDto(Offer offer) {
        return OfferDto.builder()
                .withExpert(expertMapper.toExpertDto(offer.getExpert()))
                .withCreatedDate(offer.getCreatedDate())
                .withOfferedPrice(offer.getOfferedPrice())
                .withNumOfEstimatedHours(offer.getNumOfEstimatedHours())
                .withTimeOfBeginning(offer.getTimeOfBeginning())
                .withOrder(orderMapper.toOrderDto(offer.getOrder()))
                .withOfferStatus(offer.getOfferStatus())
                .withTrackingCode(offer.getTrackingCode()).build();
    }
}
