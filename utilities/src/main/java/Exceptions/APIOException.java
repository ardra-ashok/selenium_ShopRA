package Exceptions;


import org.openqa.selenium.By;

public class APIOException extends ParentException{

        public APIOException(By locator, Throwable e) {
            errMessage = locator.toString() + "reference found was not clickable";
            error = e;
        }

    }


