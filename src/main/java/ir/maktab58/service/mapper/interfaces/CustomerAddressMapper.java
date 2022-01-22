package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.CustomerAddress;
import ir.maktab58.dto.CustomerAddressDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface CustomerAddressMapper {
    CustomerAddress toCustomerAddress(CustomerAddressDto customerAddressDto);

    CustomerAddressDto toCustomerAddressDto(CustomerAddress customerAddress);
}
