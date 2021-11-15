package MainPackage;


import Handler.*;
import Exceptions.ParentException;

import Handler.LogHandler;
import Service.Services;
//shop module - service class (page classes)- refer framework architecture
//couple of more services inside utilities(read to file,write to file)-file handler(independent classes)
// -  report handling (independent class) public static

// testModule - cucumber

public class Main  {
    public static void main(String[] args) throws ParentException, InterruptedException {

            String fileName = LogHandler.initializeReport();
            String[] itemsNeeded = {"Faded Short Sleeve T-shirts","Blouse"};
            String email = "test1249@test.com";
            String password ="PKR@PKR";
            Services shopService = new Services();
           // shopService.login(email,password);


            // shopService.shop(itemsNeeded);


             // shopService.proceedToCheckOut();


        LogHandler.readReport(fileName);
        Helpers.tearDown();

    }
    
}