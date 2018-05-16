package corbos.library.data;

public class DataException extends Exception {

    public DataException(String message, Exception innerException) {
        super(message, innerException);
    }
}
