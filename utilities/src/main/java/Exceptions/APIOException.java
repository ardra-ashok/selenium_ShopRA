package Exceptions;




public class APIOException extends ParentException{
        public APIOException(String message, Throwable e) {
            errMessage =  message;
            error = e;
        }



    }


