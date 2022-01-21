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
public enum ImageType {
    PROFILE("profile"),
    DOCUMENT("document"),
    OTHER("other");

    public ImageType getVal(String type) {
        String toLowerCase = type.toLowerCase();
        switch (toLowerCase) {
            case "profile": return PROFILE;
            case "document" : return DOCUMENT;
            case "other" : return OTHER;
            default : throw ServiceSysException.builder()
                    .withMessage(type + " is not accepted for ImageType.")
                    .withErrorCode(400).build();
        }
    }

    private @Getter String type;
}
