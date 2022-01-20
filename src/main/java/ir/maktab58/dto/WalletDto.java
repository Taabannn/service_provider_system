package ir.maktab58.dto;

import lombok.*;

import java.util.Date;

/**
 * @author Taban Soleymani
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(setterPrefix = "with")
public class WalletDto {
    private long wallet;
    private Date lastUpdate;
}
