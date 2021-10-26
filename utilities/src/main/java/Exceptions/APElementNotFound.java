package Exceptions;

import org.openqa.selenium.By;

public class APElementNotFound extends ParentException {
    public APElementNotFound(By locator, Throwable e) {
        errMessage = locator.toString() + " reference was not found";
        error = e;
    }
    public APElementNotFound(Throwable e){
        error = e;
    }
}
