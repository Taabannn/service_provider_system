package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.CustomerAddress;
import ir.maktab58.dto.CustomerAddressDto;
import ir.maktab58.service.mapper.interfaces.AddressMapper;
import ir.maktab58.service.mapper.interfaces.CustomerAddressMapper;
import ir.maktab58.service.mapper.interfaces.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class CustomerAddressMapperImpl implements CustomerAddressMapper {
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public CustomerAddress toCustomerAddress(CustomerAddressDto customerAddressDto) {
        return CustomerAddress.builder()
                .withCustomer(customerMapper.toCustomer(customerAddressDto.getCustomerDto()))
                .withAddress(addressMapper.toAddress(customerAddressDto.getAddressDto())).build();
    }

    @Override
    public CustomerAddressDto toCustomerAddressDto(CustomerAddress customerAddress) {
        return CustomerAddressDto.builder()
                .withCustomerDto(customerMapper.toCustomerDto(customerAddress.getCustomer()))
                .withAddressDto(addressMapper.toAddressDto(customerAddress.getAddress())).build();
    }
}
