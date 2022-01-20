package ir.maktab58.data.dto;

import ir.maktab58.data.entities.CustomerAddress;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @author Taban Soleymani
 */
public class AddressDto {
    private String alley;
    private String street;
    private String city;
    private String county;
    private String postalCode;
}
