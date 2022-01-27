package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.Address;
import ir.maktab58.dto.AddressDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface AddressMapper {
    Address toAddress(AddressDto addressDto);

    AddressDto toAddressDto(Address address);
}
