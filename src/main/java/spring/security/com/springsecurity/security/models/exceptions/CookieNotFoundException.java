package spring.security.com.springsecurity.security.models.exceptions;

public class CookieNotFoundException extends RuntimeException{
    public CookieNotFoundException() {
    }

    public CookieNotFoundException(String message) {
        super(message);
    }

    public CookieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CookieNotFoundException(Throwable cause) {
        super(cause);
    }

    public CookieNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
