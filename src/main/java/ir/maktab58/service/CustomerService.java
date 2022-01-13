package ir.maktab58.service;

import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;

import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface CustomerService {
    Customer customerLogin(String username, String password);

    void changeCustomerPassword(Customer customer, String newPassword);

    Customer saveNewCustomer(Customer customer);

    List<Customer> getAllCustomersByUserStatus(UserStatus userStatus);

    void updateCustomerStatus(Customer customer, UserStatus newUserStatus);
}
