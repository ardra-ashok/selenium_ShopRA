package Runners;

import Exceptions.ParentException;
import Service.Services;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNGRunner {

    private Services service;

    public TestNGRunner(){
        service = new Services();
    }

    @Test(dataProvider = "LogData",dataProviderClass= dataProvider.class )
    public void loginTest(String email,String password) throws ParentException {


        service.navigateToHome_page();
        service.clickOnSignLink();
        service.enterLoginCredentials(email, password);
        service.submitLogin();
        boolean loggedIn = service.isLoggedIn();
        assertEquals(loggedIn,true);
        service.clickOnLogout();
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        service.tearDown();
    }




}
