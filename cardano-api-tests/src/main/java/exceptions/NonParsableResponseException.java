package exceptions;

public class NonParsableResponseException extends NullPointerException {

    public NonParsableResponseException(String message) {
        super(message);
    }
}
