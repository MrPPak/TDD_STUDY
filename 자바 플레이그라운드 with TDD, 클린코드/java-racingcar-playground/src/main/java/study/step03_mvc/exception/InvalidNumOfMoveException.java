package study.step03_mvc.exception;

public class InvalidNumOfMoveException extends RuntimeException{

    public InvalidNumOfMoveException(String message) {
        super("Error: " + message);
    }
}
