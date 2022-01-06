package study.step03_mvc.exception;

public class InvalidCarNameException extends RuntimeException{

    public InvalidCarNameException(String message) {
        super("Error: " + message);;
    }
}
