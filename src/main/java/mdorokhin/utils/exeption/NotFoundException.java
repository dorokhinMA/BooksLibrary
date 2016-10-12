package mdorokhin.utils.exeption;

/**
 * @author Maxim Dorokhin
 *         09.09.2016.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}
