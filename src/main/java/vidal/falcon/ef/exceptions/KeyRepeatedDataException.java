package vidal.falcon.ef.exceptions;

public class KeyRepeatedDataException extends RuntimeException{

    public KeyRepeatedDataException() {
        super();
    }

    public KeyRepeatedDataException(String message) {
        super(message);
    }
}
