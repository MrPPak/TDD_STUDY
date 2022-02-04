package study.mvc_v1.exception;

public class InvalidPositionException extends RuntimeException{

    public InvalidPositionException(String message) {
        super("Error: " + message);
    }
}
