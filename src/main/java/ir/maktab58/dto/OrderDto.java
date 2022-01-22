package ir.maktab58.dto;

import ir.maktab58.dto.services.SubServiceDto;
import ir.maktab58.dto.users.CustomerDto;
import ir.maktab58.dto.users.ExpertDto;
import ir.maktab58.data.enums.OrderStatus;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "customer can not be null")
    private CustomerDto customer;

    private ExpertDto expert;

    @NotNull(message = "subService can not be null")
    private SubServiceDto subService;

    @NotBlank(message = "details should not be empty")
    private String details;

    private Date createdDate;

    private Date completedDate;

    @NotNull(message = "address can not be null")
    private AddressDto address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date requestedDate;

    private long OfferedPriceByCustomer;

    private OrderStatus orderStatus;

    private long trackingCode;
}
