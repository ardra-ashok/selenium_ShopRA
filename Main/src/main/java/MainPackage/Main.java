package MainPackage;


import DriverHandler.Helpers;
import Exceptions.ParentException;
import Pages.LoginPage;
import Pages.ProceedToCheckOut;
import Pages.ShopPage;
//shop module - service class (page classes)- refer framework architecture
//couple of more services inside utilities(read to file,write to file)-file handler(independent classes)
// -  report handling (independent class) public static

public class Main  {
    public static void main(String[] args)throws ParentException {
        String[] itemsNeeded = {"Faded Short Sleeve","Blouse"};
        Helpers.init();


        LoginPage testLogin = new LoginPage();
        testLogin.login("test1249@test.com","PKR@PKR");
        ShopPage goShop = new ShopPage();
        goShop.shop(itemsNeeded);

        ProceedToCheckOut proceed = new ProceedToCheckOut();
        proceed.proceedCheckOut();


        Helpers.tearDown();
    }
    
}