package Service;

import Exceptions.ParentException;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProceedToCheckOut;
import Pages.ShopPage;

public class Services {

    private static final LoginPage testLogin = new LoginPage();
    private static final HomePage home = new HomePage();



    public void login(String email,String password) throws ParentException {
        try{
            navigateToHome_page();
            clickOnSignLink();
            enterLoginCredentials(email,password);
            submitLogin();
            isLoggedIn();

        }catch(ParentException e){
            throw new ParentException("error at shop Services");
        }


    }


    public void shop(String[] itemsNeeded) throws ParentException {
        try{
            LoginPage testLogin = new LoginPage();
            testLogin.login("test1249@test.com","PKR@PKR");
            ShopPage goShop = new ShopPage();
            goShop.shop(itemsNeeded);
        }catch(ParentException e){
            throw new ParentException("error at shop Services");
        }


    }

    public void proceedToCheckOut() throws ParentException {
            ProceedToCheckOut proceed = new ProceedToCheckOut();
            proceed.proceedCheckOut();

    }

    public  void enterLoginCredentials(String email,String password) throws ParentException {
        testLogin.login(email,password);


    }
    public void submitLogin() throws ParentException {
        testLogin.clickOnSubmit();
    }
    public boolean isLoggedIn() throws ParentException {
        boolean loggedIn =  testLogin.isLoggedInCheck();
        return loggedIn;
    }

    public void navigateToHome_page() throws ParentException {
        home.goHomePage();
    }

    public void clickOnSignLink() throws ParentException {
        home.clickOnSignInLink();
    }
    public void clickOnLogout() throws ParentException{
        testLogin.logout();
    }

    public void tearDown() throws InterruptedException {
        testLogin.tearDown();
    }
}
