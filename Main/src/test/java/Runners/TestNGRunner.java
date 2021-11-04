package Runners;

import Exceptions.ParentException;
import Service.Services;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// feature file scenarios should match with the testNG
// parameters passing
// maven command to run both cucumber files and testng runner
// run a cucumber feature file from testng test method
// use data provider credentials to pass to cucumber feature file through testNG
import static org.testng.Assert.assertEquals;

public class TestNGRunner {

    private Services service;

    public TestNGRunner(){
        service = new Services();
    }
//    @BeforeTest
//    public void userOnLogin_page() throws ParentException {
//        service.navigateToHome_page();
//        service.clickOnSignLink();
//    }
//    @Test(priority=1)
//    public void hitSubmit() throws ParentException {
//        service.submitLogin();
//        boolean loggedIn = service.isLoggedIn();
//        assertEquals(loggedIn,true);
//    }
//
//    @Test(priority=0,dataProvider = "LoginData",dataProviderClass=dataProviderRepo.class )
//    public void userEnterCredentials(String email,String password) throws ParentException {
//        service.enterLoginCredentials(email, password);
//
//    }

    @Test(dataProvider = "LogData",dataProviderClass=dataProviderRepo.class )
    public void loginTest(String email,String password) throws ParentException, InterruptedException {
        service.navigateToHome_page();
        service.clickOnSignLink();
        service.enterLoginCredentials(email, password);
        service.submitLogin();
        boolean loggedIn = service.isLoggedIn();
        assertEquals(loggedIn,true);
        service.clickOnLogout();
        service.tearDown();
    }




}
