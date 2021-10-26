package Pages;

import DriverHandler.Helpers;
import Objects.ProceedToCheckOutObjects;
import Exceptions.ParentException;
import org.openqa.selenium.WebDriver;


public class ProceedToCheckOut extends Helpers {
    public ProceedToCheckOut(WebDriver driver) {
        super(driver);

    }
    public void proceedCheckOut() throws ParentException {

        actionMoveClick(ProceedToCheckOutObjects.shoppingCart);
        System.out.println("after checkout");
        // adding explicit wait
        eWaitForVisibility(ProceedToCheckOutObjects.cartCheckout,30);
        click(ProceedToCheckOutObjects.cartCheckout);
        click(ProceedToCheckOutObjects.standardCheckOut);
        click(ProceedToCheckOutObjects.proceedAddressVerify);
        click(ProceedToCheckOutObjects.agreeTermsConditions);
        click(ProceedToCheckOutObjects.proceedToPayments); click(ProceedToCheckOutObjects.chequeOption);
        click(ProceedToCheckOutObjects.confirmOrder);

        String ConfirmationText=getTextLabel(ProceedToCheckOutObjects.confirmMessage);
        if(ConfirmationText.contains("complete")) {
            System.out.println("Order Completed: Test Case Passed"); }
        else {
            System.out.println("Order Not Successful: Test Case Failed"); }

        click(ProceedToCheckOutObjects.logOutButton);
        if(getUrl().contains("controller=authentication")) {
            System.out.println("User Logged out successfully after purchase");
        }

    }

}
