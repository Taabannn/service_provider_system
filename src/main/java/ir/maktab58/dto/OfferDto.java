package ir.maktab58.dto;

import ir.maktab58.data.enums.OfferStatus;
import ir.maktab58.dto.users.ExpertDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
public class OfferDto {
    @NotNull(message = "expert can not be null")
    private ExpertDto expert;

    private Date createdDate;

    private long offeredPrice;

    private int numOfEstimatedHours;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "time of beginning can not be null")
    private Date timeOfBeginning;

    @NotNull(message = "order can not be null")
    private OrderDto order;

    private OfferStatus offerStatus;

    private long trackingCode;
}
