package ir.maktab58.exceptions;

/**
 * @author Taban Soleymani
 */
public class DuplicateUserException extends ServiceSysException {
    public DuplicateUserException(String message, int errorCode) {
        super(message, errorCode);
    }
}
