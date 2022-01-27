package ir.maktab58.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class AddressDto {
    @NotBlank(message = "alley field should not be empty")
    private String alley;

    @NotBlank(message = "street field should not be empty")
    private String street;

    @NotBlank(message = "city field should not be empty")
    private String city;

    @NotBlank(message = "county field should not be empty")
    private String county;

    @Pattern(regexp = "\\d{10}", message = "postal-code length must be 10")
    @NotBlank(message = "postalCode should not be empty")
    private String postalCode;
}
