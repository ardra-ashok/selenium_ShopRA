package Exceptions;

import org.openqa.selenium.By;

public class APElementNotSelectable extends ParentException{
    public APElementNotSelectable(By locator, Throwable e) {
        errMessage = locator.toString() + "was not Selectable";
        error = e;
    }

}
