package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Order;
import ir.maktab58.dto.OrderDto;
import ir.maktab58.service.mapper.interfaces.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class OrderMapperImpl implements OrderMapper {
    @Autowired
    private CustomerMapperImpl customerMapper;

    @Autowired
    private ExpertMapperImpl expertMapper;

    @Autowired
    private SubServiceMapperImpl subServiceMapper;

    @Autowired
    private AddressMapperImpl addressMapper;

    @Override
    public Order toOrder(OrderDto orderDto) {
        return Order.builder()
                .withCustomer(customerMapper.toCustomer(orderDto.getCustomer()))
                .withExpert(expertMapper.toExpert(orderDto.getExpert()))
                .withSubService(subServiceMapper.toSubService(orderDto.getSubService()))
                .withDetails(orderDto.getDetails())
                .withCreatedDate(orderDto.getCreatedDate())
                .withCompletedDate(orderDto.getCompletedDate())
                .withAddress(addressMapper.toAddress(orderDto.getAddress()))
                .withRequestedDate(orderDto.getRequestedDate())
                .withOfferedPriceByCustomer(orderDto.getOfferedPriceByCustomer())
                .withOrderStatus(orderDto.getOrderStatus())
                .withTrackingCode(orderDto.getTrackingCode()).build();
    }

    @Override
    public OrderDto toOrderDto(Order order) {
        return OrderDto.builder()
                .withCustomer(customerMapper.toCustomerDto(order.getCustomer()))
                .withExpert(expertMapper.toExpertDto(order.getExpert()))
                .withSubService(subServiceMapper.toSubServiceDto(order.getSubService()))
                .withDetails(order.getDetails())
                .withCreatedDate(order.getCreatedDate())
                .withCompletedDate(order.getCompletedDate())
                .withAddress(addressMapper.toAddressDto(order.getAddress()))
                .withRequestedDate(order.getRequestedDate())
                .withOfferedPriceByCustomer(order.getOfferedPriceByCustomer())
                .withOrderStatus(order.getOrderStatus())
                .withTrackingCode(order.getTrackingCode()).build();
    }
}
