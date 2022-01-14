package ir.maktab58.service;

import ir.maktab58.data.dao.AddressDao;
import ir.maktab58.data.models.Address;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public Address saveAnAddress(String alley, String street, String city, String county, String postalCode) {
        Optional<Address> foundedAddress = addressDao.findAddressByPostalCode(postalCode);
        if (foundedAddress.isPresent())
            throw ServiceSysException.builder()
                    .withMessage("The entered Address has already saved in address table.")
                    .withErrorCode(400).build();
        Address address = Address.builder()
                .withAlley(alley)
                .withCity(city)
                .withCounty(county)
                .withStreet(street)
                .withPostalCode(postalCode).build();
        return addressDao.save(address);
    }
}
