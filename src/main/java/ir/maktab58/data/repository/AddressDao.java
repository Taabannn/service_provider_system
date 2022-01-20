package ir.maktab58.data.repository;

import ir.maktab58.data.entities.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface AddressDao extends PagingAndSortingRepository<Address, Integer> {
    Optional<Address> findAddressByPostalCode(String postalCode);
}
