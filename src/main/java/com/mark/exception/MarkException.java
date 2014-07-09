package com.mark.exception;

public class MarkException extends RuntimeException {
    /**
     * Default constructor
     */
    public MarkException() {
        super();
    }

    /**
     * @param message
     */
    public MarkException(String message) {
        super(message);
    }

    /**
     * @param e
     */
    public MarkException(Exception e) {
        e.printStackTrace();
    }


    /**
     * @param message
     * @param throwable
     */
    public MarkException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
