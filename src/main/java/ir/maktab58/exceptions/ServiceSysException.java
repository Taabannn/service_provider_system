package ir.maktab58.exceptions;

import lombok.Builder;

/**
 * @author Taban Soleymani
 */
public class ServiceSysException extends RuntimeException {
    private final int errorCode;

    @Builder(setterPrefix = "with")
    public ServiceSysException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
