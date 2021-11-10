package Handler;

import Exceptions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Helpers {



    private static WebDriver driver;
    public Helpers() {
    }

    public static List<WebElement> findList(By locator) throws ParentException {
        try {
            return getDriver().findElements(locator);
        } catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    public static WebElement find(By locator) throws ParentException {
        WebElement we = null;
        try {

            if (getDriver().findElement(locator).isDisplayed()) {
                we =  getDriver().findElement(locator);
            }
        } catch (NoSuchElementException e) {
            throw new APElementNotFound(locator,e);
        }catch (NullPointerException  e){
            throw new APNullPointerException(locator,e);
        }
        return we;
    }


    public static void type(String text, By locator) throws ParentException {
        try{
            find(locator).clear();
            find(locator).sendKeys(text);
        }catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }

    }
    public static void click(By locator) throws ParentException {

        try{
            find(locator).click();
        }catch (NoSuchElementException e){
            throw new APElementNotFound(locator, e);
        } catch (ElementNotInteractableException e){
            throw new APElementNotClickable(locator, e);
        }catch(NullPointerException e){
            throw new APNullPointerException(locator, e);
        }

    }
    public static void clear(By locator) throws ParentException{
        try {
            find(locator).clear();
        }
        catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    // add exception
    public static String getUrl() {
            return getDriver().getCurrentUrl();
    }

    public static Boolean checkEquality(String text1,String text2) {
        return text2.equals(text1);
    }
    public static String getTextLabel(By locator) throws ParentException {
        try {
            return find(locator).getText();
        }
        catch (NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        }
    }
    public static void selectDropDown(By locator,String input) throws ParentException{
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
    public  static void eWaitForVisibility(By locator, int waitTime){
        WebDriverWait eWait = new WebDriverWait(getDriver(),waitTime);
        eWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void actionMoveClick(By locator) throws ParentException{
        try{
            Actions action = new Actions(getDriver());
            action.moveToElement(find(locator)).build().perform();
        }catch(NoSuchElementException e) {
            throw new APElementNotFound(locator, e);
        }
    }
    public static void JsExecutorClick(By locator) throws ParentException{
        try{
            WebElement element = find(locator);
            JavascriptExecutor executor = (JavascriptExecutor)getDriver();
            executor.executeScript("arguments[0].click();", element);
        }catch(NoSuchElementException e){
            throw new APElementNotFound(locator,e);
        } catch(JavascriptException e){
            throw new APJavascriptException(locator,e);
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

    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    public static void navigateToUrl(String url){
        getDriver().get(url);
    }
}
