package Exceptions;

import Handler.LogHandler;

public class ParentException extends Exception{
    public String errMessage;
    public Throwable error;

    public ParentException() {}


    public ParentException(Exception e) {
        error = e;
    }
    public ParentException(String message){
        errMessage = message;

    }
    public void log(){
        LogHandler.log(errMessage);
    }







}
