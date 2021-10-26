package MainPackage;


import DriverHandler.Helpers;
import Exceptions.ParentException;

public class Main  {
    public static void main(String[] args)throws ParentException {
        Helpers.init();
        Helpers.navigate();
        Helpers.login();
        Helpers.shop();
        Helpers.proceedCheckout();
        Helpers.tearDown();
    }
    
}