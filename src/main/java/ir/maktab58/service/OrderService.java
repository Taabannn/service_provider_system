package ir.maktab58.service;

import ir.maktab58.data.models.Address;
import ir.maktab58.data.models.Order;
import ir.maktab58.data.models.services.SubService;
import ir.maktab58.data.models.users.Customer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface OrderService {
    Order saveNewOrder(Customer customer, Address address, SubService subService, String details, long offeredPriceByCustomer, Date requestedDate);

    List<Order> getOrdersBySubService(SubService subService);
}
