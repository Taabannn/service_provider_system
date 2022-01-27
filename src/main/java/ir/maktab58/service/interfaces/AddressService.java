package ir.maktab58.service.interfaces;

import ir.maktab58.data.entities.Address;

/**
 * @author Taban Soleymani
 */
public interface AddressService {
    Address saveAnAddress(String alley, String street, String city, String county, String postalCode);
}
