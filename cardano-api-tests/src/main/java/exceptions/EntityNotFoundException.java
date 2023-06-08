package exceptions;

public class EntityNotFoundException extends NullPointerException {
    public EntityNotFoundException(String message){
        super(message);
    }
}
