package ir.maktab58.exceptions;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

/**
 * @author Taban Soleymani
 */
public class DuplicateUserException extends ServiceSysException {
    public DuplicateUserException(String message, int errorCode) {
        super(message, errorCode);
    }
}
