package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.Offer;
import ir.maktab58.dto.OfferDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface OfferMapper {
    Offer toOffer(OfferDto offerDto);

    OfferDto toOfferDto(Offer offer);
}
