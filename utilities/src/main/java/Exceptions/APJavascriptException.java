package Exceptions;

import org.openqa.selenium.By;

public class APJavascriptException extends ParentException{

    public APJavascriptException(By locator, Throwable e)  {
        errMessage = locator.toString() +" reference was not found";
        error = e;

    }

}
