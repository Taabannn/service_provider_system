package ir.maktab58.service.mapper.Impl;

import ir.maktab58.data.entities.Order;
import ir.maktab58.dto.OrderDto;
import ir.maktab58.service.mapper.interfaces.OrderMapper;
import org.springframework.stereotype.Component;

/**
 * @author Taban Soleymani
 */
@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto toOrderDto(Order order) {
        return null;
    }
}
