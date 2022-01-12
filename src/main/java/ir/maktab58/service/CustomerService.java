package ir.maktab58.service;

import ir.maktab58.data.models.users.Customer;
import ir.maktab58.data.models.users.Expert;
import org.springframework.stereotype.Service;

/**
 * @author Taban Soleymani
 */
public interface CustomerService {
    Customer customerLogin(String username, String password);

    void changeCustomerPassword(Customer customer, String newPassword);

    Customer saveNewCustomer(Customer customer);
}
