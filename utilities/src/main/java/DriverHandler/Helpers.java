package DriverHandler;



import Exceptions.APElementNotClickable;
import Exceptions.APElementNotSelectable;
import Pages.LoginPage;
import Pages.ProceedToCheckOut;
import Pages.SearchPage;
import Pages.ShopPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import Exceptions.APElementNotFound;
import Exceptions.ParentException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
    private static WebDriver driver;


    public Helpers(WebDriver driver) {
        this.driver = driver;
    }

    public static void navigate(){
        getDriver().get(HelperObjects.baseUrl);
    }
    public static void login() throws ParentException{
         getDriver().findElement(HelperObjects.loginButton).click();
         LoginPage testLogin = new LoginPage(getDriver());
         testLogin.login(HelperObjects.email, HelperObjects.password);
    }
    public static void shop() throws ParentException{
        ShopPage doShopping = new ShopPage(getDriver());
        doShopping.shop(HelperObjects.itemsNeeded);
    }

    public static void proceedCheckout() throws ParentException{
        ProceedToCheckOut proceed = new ProceedToCheckOut(getDriver());
        proceed.proceedCheckOut();
    }
    public static SearchPage searchInit() throws ParentException{
        SearchPage search = new SearchPage(getDriver());
        return search;
    }


    protected static List<WebElement> findList(By locator) throws ParentException{
        try {
            return getDriver().findElements(locator);
        } catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    protected static WebElement find(By locator) throws ParentException {
        try{
            return getDriver().findElement(locator);
        } catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }



    protected void type (String text, By locator) throws ParentException {
        try{
            find(locator).clear();
            find(locator).sendKeys(text);
        }catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }

    }
    protected void click(By locator) throws ParentException {
        try{
            find(locator).click();
        }catch (NoSuchElementException e){
            throw new APElementNotFound(locator, e);
        } catch (ElementNotInteractableException e){
            throw new APElementNotClickable(locator, e);
        }

    }


    protected void clear(By locator) throws ParentException{
        try {
            find(locator).clear();
        }
        catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    protected String getUrl() {
            return getDriver().getCurrentUrl();
    }

    protected Boolean checkEquality(String text1,String text2) {
        return text2.equals(text1);
    }
    protected String getTextLabel(By locator) throws ParentException {
        try {
            return find(locator).getText();
        }
        catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    protected static void selectDropDown(By locator,String input) throws ParentException{
        try{
            Select dropDown = new Select(getDriver().findElement(locator));
            dropDown.selectByVisibleText(input);
        }
        catch (ElementNotSelectableException e){
            throw new APElementNotSelectable(locator,e);
        }
        catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    protected  static void eWaitForVisibility(By locator, int waitTime){
        WebDriverWait eWait = new WebDriverWait(getDriver(),waitTime);
        eWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected static void actionMoveClick(By locator) throws ParentException{
        try{
            Actions action = new Actions(getDriver());
            action.moveToElement(find(locator)).build().perform();
        }catch(NoSuchElementException e) {
            throw new APElementNotFound(locator, e);
        }
    }
    protected static void JsExecutorClick(By locator) throws ParentException{
        try{
            JavascriptExecutor executor = (JavascriptExecutor)getDriver();
            WebElement element = find(locator);
            executor.executeScript("arguments[0].click();", element);
        }catch(NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }

    private static WebDriver getDriver() {
        if (driver == null)
            init();
        return driver;
    }

    public static void  init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\61491\\sdettesting\\Softwares\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        driver.close();
    }


}
