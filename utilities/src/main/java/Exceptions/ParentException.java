package Exceptions;

public class ParentException extends Throwable{
    public String errMessage;
    public Throwable error;

    public ParentException() {}

    public ParentException(Exception e) {
        super("Operation failed",e);
        errMessage = "Operation failed";
        error = e;
    }

}
