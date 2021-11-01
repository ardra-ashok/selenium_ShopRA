package Exceptions;


import org.openqa.selenium.By;

public class APNullPointerException extends ParentException{
    public APNullPointerException(By locator, Throwable e)  {
        errMessage = "Null pointer caught at:"+locator.toString();
        error = e;
    }

}
