package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Address;
import ir.maktab58.dto.AddressDto;
import ir.maktab58.service.mapper.interfaces.AddressMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class AddressMapperImpl implements AddressMapper {
    @Override
    public Address toAddress(AddressDto addressDto) {
        return Address.builder()
                .withAlley(addressDto.getAlley())
                .withStreet(addressDto.getStreet())
                .withCity(addressDto.getCity())
                .withCounty(addressDto.getCounty())
                .withPostalCode(addressDto.getPostalCode()).build();
    }

    @Override
    public AddressDto toAddressDto(Address address) {
        return AddressDto.builder()
                .withAlley(address.getAlley())
                .withStreet(address.getStreet())
                .withCity(address.getCity())
                .withCounty(address.getCounty())
                .withPostalCode(address.getPostalCode()).build();
    }
}
