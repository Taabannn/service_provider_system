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
public enum TransactionType {
    DEPOSIT("deposit"),
    ORDER_PAYMENT("order-payment");

    public static TransactionType getVal(String type) {
        String lowerCase = type.toLowerCase();
        switch (lowerCase) {
            case "deposit" : return DEPOSIT;
            case "order-payment" : return ORDER_PAYMENT;
            default : throw ServiceSysException.builder()
                    .withMessage(type + " is not accepted for TransactionType.")
                    .withErrorCode(400).build();
        }
    }

    private @Getter String type;
}
