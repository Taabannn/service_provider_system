package ir.maktab58.data.models.enums;

import ir.maktab58.exceptions.ServiceSysException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Taban Soleymani
 */
@AllArgsConstructor
@NoArgsConstructor
public enum UserStatus {
    NEW("new"),
    VERIFIED("verified"),
    WAITING_FOR_VERIFYING("waiting-for-verifying");

    public static UserStatus getVal(String type) {
        String lowerCase = type.toLowerCase();
        switch (lowerCase) {
            case "new" : return NEW;
            case "verified" : return VERIFIED;
            case "waiting-for-verifying" : return WAITING_FOR_VERIFYING;
            default : throw ServiceSysException.builder()
                    .withMessage(type + " is not accepted for UserStatus.")
                    .withErrorCode(400).build();
        }
    }

    private @Getter String status;
}
