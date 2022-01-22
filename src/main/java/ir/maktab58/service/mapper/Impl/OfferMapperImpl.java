package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Offer;
import ir.maktab58.dto.OfferDto;
import ir.maktab58.service.mapper.interfaces.OfferMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class OfferMapperImpl implements OfferMapper {
    @Override
    public Offer toOffer(OfferDto offerDto) {
        return null;
    }

    @Override
    public OfferDto toOfferDto(Offer offer) {
        return null;
    }
}
