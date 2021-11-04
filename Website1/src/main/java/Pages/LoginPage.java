package Pages;



import Exceptions.ParentException;
import Handler.Helpers;
import Handler.LogHandler;
import Objects.LoginObjects;

import org.openqa.selenium.By;

public class LoginPage  {
    private static boolean isLoggedIn;
    public void login(String email, String password) throws ParentException {
        try{

                Helpers.type(email, LoginObjects.emailField);
                Helpers.type(password, LoginObjects.passwordField);
            }catch (ParentException e){
                e.log();
            }

    }

    public static void clickOnSubmit() throws ParentException {
        Helpers.click(LoginObjects.loginButton);
    }


    public static boolean isLoggedInCheck() throws ParentException {
        if(Helpers.getUrl().contains("controller=authentication")) {
           // LogHandler.log(Helpers.getTextLabel(LoginObjects.errorMessage));
            isLoggedIn = false;
        }
        else{
            String userText = Helpers.getTextLabel(LoginObjects.textField);
            if(userText.contains("Vsoft")) {
                isLoggedIn = true;
            }


        }
        return isLoggedIn;
    }
    public static void logout() throws ParentException{
        Helpers.click(LoginObjects.logoutButton);
    }

    public static void tearDown() throws InterruptedException {
        Helpers.tearDown();
    }
}
