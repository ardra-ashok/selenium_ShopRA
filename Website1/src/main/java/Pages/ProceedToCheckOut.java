package Pages;

import Exceptions.ParentException;
import Handler.Helpers;
import Objects.ProceedToCheckOutObjects;


public class ProceedToCheckOut  {




    public void proceedCheckOut() throws ParentException {

        Helpers.actionMoveClick(ProceedToCheckOutObjects.shoppingCart);
        System.out.println("after checkout");
        // adding explicit wait
        Helpers.eWaitForVisibility(ProceedToCheckOutObjects.cartCheckout,30);
        Helpers.click(ProceedToCheckOutObjects.cartCheckout);
        Helpers.click(ProceedToCheckOutObjects.standardCheckOut);
        Helpers.click(ProceedToCheckOutObjects.proceedAddressVerify);
        Helpers.click(ProceedToCheckOutObjects.agreeTermsConditions);
        Helpers.click(ProceedToCheckOutObjects.proceedToPayments);
        Helpers.click(ProceedToCheckOutObjects.chequeOption);
        Helpers.click(ProceedToCheckOutObjects.confirmOrder);

        String ConfirmationText=Helpers.getTextLabel(ProceedToCheckOutObjects.confirmMessage);
        if(ConfirmationText.contains("complete")) {
            System.out.println("Order Completed: Test Case Passed"); }
        else {
            System.out.println("Order Not Successful: Test Case Failed"); }

        Helpers.click(ProceedToCheckOutObjects.logOutButton);
        if(Helpers.getUrl().contains("controller=authentication")) {
            System.out.println("User Logged out successfully after purchase");
        }

    }

}
