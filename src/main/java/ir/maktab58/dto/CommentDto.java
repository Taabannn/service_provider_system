package ir.maktab58.dto;

import lombok.*;

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
public class CommentDto {
    @NotBlank(message = "comment detail should not be empty")
    private String detail;

    private double score;

    private Date createdDate;

    @NotNull(message = "order can not be null")
    private OrderDto order;

    private long trackingCode;
}
