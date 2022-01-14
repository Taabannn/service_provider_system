package ir.maktab58.service;

import ir.maktab58.data.models.Address;

/**
 * @author Taban Soleymani
 */
public interface AddressService {
    Address saveAnAddress(String alley, String street, String city, String county, String postalCode);
}
