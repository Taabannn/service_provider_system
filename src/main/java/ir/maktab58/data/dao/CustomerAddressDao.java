package ir.maktab58.data.dao;

import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.CustomerAddress;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface CustomerAddressDao extends PagingAndSortingRepository<CustomerAddress, Integer> {
    List<CustomerAddress> findCustomerAddressByAddress(Address address);
}
