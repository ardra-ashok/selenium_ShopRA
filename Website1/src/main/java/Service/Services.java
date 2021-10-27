package Service;

import Exceptions.ParentException;
import Handler.LogHandler;
import Pages.LoginPage;
import Pages.ProceedToCheckOut;
import Pages.ShopPage;

public class Services {


    public void shop(String[] itemsNeeded) {
        try{
            LoginPage testLogin = new LoginPage();
            testLogin.login("test1249@test.com","PKR@PKR");
            ShopPage goShop = new ShopPage();
            goShop.shop(itemsNeeded);
        }catch(ParentException e){
            LogHandler.log("Error at Shop Services");
        }


    }


   public void login(){
       LoginPage testLogin = new LoginPage();
       testLogin.login("test1249@test.com","PKR@PKR");


         }
    public void proceedToCheckOut(){
        try{

            ProceedToCheckOut proceed = new ProceedToCheckOut();
            proceed.proceedCheckOut();
        }catch(ParentException e){
            LogHandler.log("error at ProceedToCheckout");
        }
    }



}
