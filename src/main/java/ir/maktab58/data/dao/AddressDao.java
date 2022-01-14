package ir.maktab58.data.dao;

import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.users.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Transactional
@Repository
public interface AddressDao extends PagingAndSortingRepository<Address, Integer> {
    Optional<Address> findAddressByPostalCode(String postalCode);
}
