package ir.maktab58.service.impl;

import ir.maktab58.data.repository.OrderRepository;
import ir.maktab58.data.entities.Address;
import ir.maktab58.data.entities.Order;
import ir.maktab58.data.enums.OrderStatus;
import ir.maktab58.data.entities.services.SubService;
import ir.maktab58.data.entities.users.Customer;
import ir.maktab58.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Taban Soleymani
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderDao;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    OrderServiceImpl orderService;

    @Override
    public Order saveNewOrder(Customer customer, Address address, SubService subService, String details, long offeredPriceByCustomer, Date requestedDate) {
        customerService.addAddressToCustomerAddressList(customer, address);
        Order order = Order.builder()
                .withAddress(address)
                .withRequestedDate(requestedDate)
                .withOfferedPriceByCustomer(offeredPriceByCustomer)
                .withCustomer(customer)
                .withSubService(subService)
                .withDetails(details)
                .withOrderStatus(OrderStatus.WAITING_FOR_EXPERT_OFFER).build();
        return orderDao.save(order);
    }

    @Override
    public List<Order> getOrdersBySubService(SubService subService) {
        return orderDao.findOrdersBySubService(subService);
    }

    public Optional<Order> findOrderByOrderId(int orderId) {
        return orderDao.findById(orderId);
    }

    public void updateOrderStatusToWaitingForCustomerChoice(Order order) {
        orderDao.updateOrderStatus(OrderStatus.WAITING_FOR_CHOOSING_EXPERT, order.getId());
    }
}
