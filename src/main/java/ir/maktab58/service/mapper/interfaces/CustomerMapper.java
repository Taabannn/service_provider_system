package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.dto.users.CustomerDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface CustomerMapper {
    Customer toCustomer(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);
}
