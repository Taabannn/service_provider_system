package ir.maktab58.data.enums;

import ir.maktab58.exceptions.ServiceSysException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Taban Soleymani
 */
@NoArgsConstructor
@AllArgsConstructor
public enum TransactionStatus {
    SUCCESSFUL("successful"),
    FAILED("failed");

    public static TransactionStatus getVal(String status) {
        String lowerCase = status.toLowerCase();
        switch (lowerCase) {
            case "successful" : return SUCCESSFUL;
            case "failed" : return FAILED;
            default : throw ServiceSysException.builder()
                    .withMessage(status + " is not accepted for TransactionStatus.")
                    .withErrorCode(400).build();
        }
    }

    private @Getter String status;
}
