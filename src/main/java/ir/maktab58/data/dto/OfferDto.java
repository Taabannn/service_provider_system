package ir.maktab58.data.dto;

import ir.maktab58.data.dto.users.ExpertDto;
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
public class OfferDto {
    private ExpertDto expert;
    private Date createdDate;
    private long offeredPrice;
    private int numOfEstimatedHours;
    private Date timeOfBeginning;
    private OrderDto order;
}
