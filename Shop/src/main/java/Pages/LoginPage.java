package Pages;


import DriverHandler.Helpers;
import Exceptions.ParentException;
import Objects.LoginObjects;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Helpers {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email,String password) throws ParentException {
        type(email, LoginObjects.emailField);
        type(password, LoginObjects.passwordField);
        click(LoginObjects.loginButton);
        // System.out.println(driver.getCurrentUrl());

        if(getUrl().contains("controller=authentication")) {
            System.out.println(find(LoginObjects.errorMessage).getText());
        }
        else {
            String userText= getTextLabel(LoginObjects.textField);
            if(userText.contains("Vsoft")) {
                System.out.println("User Login Successful");
            }
        }
    }
}
