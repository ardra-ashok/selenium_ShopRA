package Exceptions;

import Handler.LogHandler;
import org.openqa.selenium.By;


public class APElementNotFound extends ParentException {


    public APElementNotFound(By locator, Throwable e)  {
        errMessage = locator.toString() +" reference was not found";
        error = e;

    }


}
