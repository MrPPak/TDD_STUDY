package study.mvc_v1.exception;

public class InvalidCarNameException extends RuntimeException{

    public InvalidCarNameException(String message) {
        super("Error: " + message);;
    }
}
