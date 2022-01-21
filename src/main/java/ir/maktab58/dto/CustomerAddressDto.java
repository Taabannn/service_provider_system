package ir.maktab58.dto;

import ir.maktab58.dto.users.CustomerDto;

import javax.validation.constraints.NotNull;

/**
 * @author Taban Soleymani
 */
public class CustomerAddressDto {
    @NotNull(message = "customer should not be null")
    private CustomerDto customerDto;

    @NotNull(message = "address should not be null")
    private AddressDto addressDto;
}
