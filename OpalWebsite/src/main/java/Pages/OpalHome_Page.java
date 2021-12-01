package Pages;

import Properties.TestProps;
import abstracts.BasePage;
import core.WebDriverHandler;
import exceptions.NavigationException;
import exceptions.OperationNotSuccessfulException;
import exceptions.PageNotLoadedException;
import exceptions.WebElementNotFoundException;
import objects.OpalHome_Object;
import objects.OpalMyAccount_Object;
import utils.RobotHandler;

public class OpalHome_Page {
    private WebDriverHandler webDriverHandler;
    private TestProps testProps;

    public OpalHome_Page(WebDriverHandler webDriverHandler, TestProps testProps) {
        this.webDriverHandler = webDriverHandler;
        this.testProps = testProps;
    }

    @Override
    public boolean isPageLoaded() throws PageNotLoadedException {
        if (!(webDriverHandler.validatePageByURL(testProps.testPropertiesMap.get("opal.website"))))
            throw new PageNotLoadedException("Opal website home page");
        return true;

    }

    @Override
    public void navigate() throws NavigationException {
        webDriverHandler.navigateToUrl(testProps.testPropertiesMap.get("opal.website"));
    }

    public void loginToOpalWebSite(String username, String password) throws PageNotLoadedException, WebElementNotFoundException {
        isPageLoaded();
        webDriverHandler.enterData(OpalHome_Object.username_Input, username);
        webDriverHandler.enterData(OpalHome_Object.password_Input, password);
        webDriverHandler.waitForDuration(2);
        webDriverHandler.submitPageByElement(OpalHome_Object.password_Input);

        webDriverHandler.waitForElement(OpalMyAccount_Object.logout_Btn, 60);
    }

    public void logOutFromOpalWebsite() throws OperationNotSuccessfulException {
        try {
//            webDriverHandler.waitForElementToBeClickable(OpalMyAccount_Object.logout_Btn, 10);
            webDriverHandler.scrollToElement(OpalMyAccount_Object.logout_Btn);
            webDriverHandler.waitForElementToBeClickable(OpalMyAccount_Object.logout_Btn, 10);
            webDriverHandler.click(OpalMyAccount_Object.logout_Btn);
            webDriverHandler.dismissAlert();
        } catch (WebElementNotFoundException e) {
            throw new OperationNotSuccessfulException("Could not log out of Opal website!");
        }
    }
}
