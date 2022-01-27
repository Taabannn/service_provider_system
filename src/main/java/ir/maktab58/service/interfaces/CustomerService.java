package ir.maktab58.service.interfaces;

import ir.maktab58.data.entities.Address;
import ir.maktab58.data.enums.UserStatus;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.dto.users.CustomerDto;

import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface CustomerService {
    Customer customerLogin(CustomerDto customerDto);

    void changeCustomerPassword(CustomerDto customerDto, String newPassword);

    Customer saveNewCustomer(Customer customer);

    List<Customer> getAllCustomersByUserStatus(UserStatus userStatus);

    void updateCustomerStatus(Customer customer, UserStatus newUserStatus);

    void addAddressToCustomerAddressList(Customer customer, Address address);
}
