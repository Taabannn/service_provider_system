package ir.maktab58.dto;

import lombok.*;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class AddressDto {
    private String alley;
    private String street;
    private String city;
    private String county;
    private String postalCode;
}
