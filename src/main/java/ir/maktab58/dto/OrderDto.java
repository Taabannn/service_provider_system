package ir.maktab58.dto;

import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.data.enums.OrderStatus;
import lombok.*;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class OrderDto {
    private CustomerDto customer;
    private ExpertDto expert;
    private SubServiceDto subService;
    private String details;
    private Date createdDate;
    private Date completedDate;
    private AddressDto address;
    private Date requestedDate;
    private long OfferedPriceByCustomer;
    private OrderStatus orderStatus;
}
