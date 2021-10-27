package Pages;


import Exceptions.ParentException;
import Handler.Helpers;
import Handler.LogHandler;
import Objects.LoginObjects;


public class LoginPage  {



    public void login(String email, String password)  {
        try {
            Helpers.click(LoginObjects.goLoginPage);
            Helpers.type(email, LoginObjects.emailField);
            Helpers.type(password, LoginObjects.passwordField);
            System.out.println("here1");
            Helpers.click(LoginObjects.loginButton);
            // System.out.println(driver.getCurrentUrl());

            if(Helpers.getUrl().contains("controller=authentication")) {
                System.out.println(Helpers.find(LoginObjects.errorMessage).getText());
            }
            else {
                String userText = Helpers.getTextLabel(LoginObjects.textField);
                if(userText.contains("Vsoft")) {
                    System.out.println("User Login Successful");
                }
            }

        }catch(ParentException e){
            LogHandler.log("login failed");
        }

    }
}
