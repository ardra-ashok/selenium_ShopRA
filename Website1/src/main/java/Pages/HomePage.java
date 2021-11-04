package Pages;

import Exceptions.ParentException;
import Objects.HomeObjects;
import Handler.Helpers;


public class HomePage {

    public static void goHomePage()  {
        Helpers.navigateToUrl(HomeObjects.baseUrl);
    }
    public static void clickOnSignInLink() throws ParentException {
        Helpers.click(HomeObjects.loginLink);
    }
}
