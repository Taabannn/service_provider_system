package ir.maktab58.data.enums;

import ir.maktab58.exceptions.ServiceSysException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Taban Soleymani
 */
@AllArgsConstructor
@NoArgsConstructor
public enum OfferStatus {
    ACCEPTED("accepted"),
    REJECTED("rejected"),
    UNKNOWN("unknown");

    public static OfferStatus getVal(String status) {
        String lowerCase = status.toLowerCase();
        switch (lowerCase) {
            case "accepted" : return ACCEPTED;
            case "rejected" : return REJECTED;
            case "unknown" : return UNKNOWN;
            default : throw ServiceSysException.builder()
                    .withMessage(status + " is not accepted for OfferStatus.")
                    .withErrorCode(400).build();
        }
    }

    private @Getter String status;
}
