package Exceptions;

import Handler.LogHandler;

public class ParentException extends Exception{
    public String errMessage;
    public Throwable error;

    public ParentException() {}

    public ParentException(Exception e) {
        super("Operation failed",e);
        errMessage = "Operation failed";
        error = e;



    }

}
