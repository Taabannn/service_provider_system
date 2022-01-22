package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.service.mapper.interfaces.CustomerMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        return null;
    }
}
