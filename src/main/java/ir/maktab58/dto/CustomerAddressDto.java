package ir.maktab58.dto;

import ir.maktab58.dto.users.CustomerDto;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class CustomerAddressDto {
    @NotNull(message = "customer should not be null")
    private CustomerDto customerDto;

    @NotNull(message = "address should not be null")
    private AddressDto addressDto;
}
