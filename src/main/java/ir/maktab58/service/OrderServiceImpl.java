package ir.maktab58.service;

import ir.maktab58.data.dao.AddressDao;
import ir.maktab58.data.dao.CustomerDao;
import ir.maktab58.data.dao.OrderDao;
import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.users.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    OrderServiceImpl orderService;

    public Order saveNewOrder(Customer customer, Address address, String details, long offeredPriceByCustomer, Date requestedDate) {
        customerService.addAddressToCustomerAddressList(customer, address);
        Order order = Order.builder()
                .withAddress(address)
                .withRequestedDate(requestedDate)
                .withOfferedPriceByCustomer(offeredPriceByCustomer)
                .withCustomer(customer)
                .withDetails(details).build();
        return orderDao.save(order);
    }
}
