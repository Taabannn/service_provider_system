package ir.maktab58.data.repository;

import ir.maktab58.data.entities.Address;
import ir.maktab58.data.entities.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
    List<CustomerAddress> findCustomerAddressByAddress(Address address);
}
