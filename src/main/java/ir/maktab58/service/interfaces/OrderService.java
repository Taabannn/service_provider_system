package ir.maktab58.service.interfaces;

import ir.maktab58.data.entities.Address;
import ir.maktab58.data.entities.Order;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Customer;

import java.util.Date;
import java.util.List;

/**
 * @author Taban Soleymani
 */
public interface OrderService {
    Order saveNewOrder(Customer customer, Address address, SubService subService, String details, long offeredPriceByCustomer, Date requestedDate);

    List<Order> getOrdersBySubService(SubService subService);
}
