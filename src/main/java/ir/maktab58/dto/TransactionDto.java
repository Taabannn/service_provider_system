package ir.maktab58.dto;

import ir.maktab58.data.enums.TransactionStatus;
import lombok.*;

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
public class TransactionDto {
    @NotNull(message = "wallet could not be null")
    private WalletDto walletDto;

    private Date creationDate;

    private TransactionStatus transactionStatus;

    private long trackingCode;
}
