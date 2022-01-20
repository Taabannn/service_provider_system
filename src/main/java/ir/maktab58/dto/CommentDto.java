package ir.maktab58.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {
    private String detail;
    private double score;
    private Date createdDate;
    private OrderDto order;
}
