package me.jinmin.board.exception;

public class EmailDuplicateException extends RuntimeException {
    public EmailDuplicateException(String message) {
        super(message);
    }
}
