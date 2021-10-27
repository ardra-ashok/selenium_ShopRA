package Exceptions;

import Handler.LogHandler;
import org.openqa.selenium.By;


public class APElementNotClickable extends ParentException{

    public APElementNotClickable(By locator, Throwable e) {

        errMessage = locator.toString() + "reference found was not clickable";
        error = e;
        LogHandler.log(errMessage);
    }

}
