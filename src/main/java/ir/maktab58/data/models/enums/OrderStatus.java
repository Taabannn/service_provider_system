package ir.maktab58.data.models.enums;

import ir.maktab58.exceptions.ServiceSysException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Taban Soleymani
 */
@NoArgsConstructor
@AllArgsConstructor
public enum OrderStatus {
    WAITING_FOR_EXPERT_OFFER("waiting-for-expert-offer"),
    WAITING_FOR_CHOOSING_EXPERT("waiting-for-choosing-expert"),
    WAITING_FOR_EXPERT_COMING_TO_YOUR_PLACE("waiting-for-expert-coming-to-your-place"),
    STARTED("started"),
    COMPLETED("completed"),
    PAID("PAID");

    public static OrderStatus getVal(String type) {
        String lowerCase = type.toLowerCase();
        switch (lowerCase) {
            case "waiting-for-expert-offer" : return WAITING_FOR_EXPERT_OFFER;
            case "waiting-for-choosing-expert" : return WAITING_FOR_CHOOSING_EXPERT;
            case "waiting-for-expert-coming-to-your-place" : return WAITING_FOR_EXPERT_COMING_TO_YOUR_PLACE;
            case "started" : return STARTED;
            case "completed" : return COMPLETED;
            case "paid" : return PAID;
            default : throw ServiceSysException.builder()
                    .withMessage(type + " is not accepted for OrderStatus.")
                    .withErrorCode(400).build();
        }
    }

    private @Getter String status;
}
