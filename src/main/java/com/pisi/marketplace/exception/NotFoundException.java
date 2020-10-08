package com.pisi.marketplace.exception;

public class NotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -6497013832732840378L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
