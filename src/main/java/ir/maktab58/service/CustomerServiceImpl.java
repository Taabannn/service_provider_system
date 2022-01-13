package ir.maktab58.service;

import ir.maktab58.data.dao.CustomerDao;
import ir.maktab58.data.models.enums.UserStatus;
import ir.maktab58.data.models.users.Customer;
import ir.maktab58.exceptions.ServiceSysException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer customerLogin(String username, String password) {
        Optional<Customer> foundedCustomer = customerDao.findCustomerByUsernameAndPassword(username, password);
        if (foundedCustomer.isEmpty())
            throw ServiceSysException.builder()
                    .withMessage("Invalid username or pass.\n" +
                            "Please try again!").withErrorCode(400).build();
        return foundedCustomer.get();
    }

    @Override
    public void changeCustomerPassword(Customer customer, String newPassword) {
        customerDao.updateCustomerPassword(customer.getUsername(), customer.getPassword(), newPassword);
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public List<Customer> getAllCustomersByUserStatus(UserStatus userStatus) {
        return customerDao.getAllByUserStatus(userStatus);
    }

    @Override
    public void updateCustomerStatus(Customer customer, UserStatus newUserStatus) {
        customerDao.updateCustomerStatus(customer.getUsername(), customer.getPassword(), newUserStatus);
    }
}
