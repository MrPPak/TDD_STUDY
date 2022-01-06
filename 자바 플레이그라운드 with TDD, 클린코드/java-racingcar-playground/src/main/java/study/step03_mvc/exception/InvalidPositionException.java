package study.step03_mvc.exception;

public class InvalidPositionException extends RuntimeException{

    public InvalidPositionException(String message) {
        super("Error: " + message);
    }
}
