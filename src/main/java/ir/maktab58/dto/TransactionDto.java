package ir.maktab58.dto;

import ir.maktab58.data.enums.TransactionStatus;
import ir.maktab58.data.enums.TransactionType;
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
    private long cost;

    @NotNull(message = "wallet could not be null")
    private WalletDto walletDto;

    private Date creationDate;

    private TransactionStatus transactionStatus;

    private TransactionType transactionType;

    private long trackingCode;
}
