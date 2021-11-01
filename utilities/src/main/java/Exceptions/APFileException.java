package Exceptions;

public class APFileException extends ParentException {

    public APFileException(String message,Throwable e) {
        errMessage = message;
        error = e;
    }
}
