package ir.maktab58.service.mapper.interfaces;

import ir.maktab58.data.entities.Order;
import ir.maktab58.dto.OrderDto;
import org.mapstruct.Mapper;

/**
 * @author Taban Soleymani
 */
@Mapper
public interface OrderMapper {
    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);
}
