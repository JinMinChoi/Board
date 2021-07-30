package me.jinmin.board.exception;

public class NotFoundBoardException extends RuntimeException {
    public NotFoundBoardException(String message) {
        super(message);
    }

    public NotFoundBoardException(String message, Throwable cause) {
        super(message, cause);
    }
}
