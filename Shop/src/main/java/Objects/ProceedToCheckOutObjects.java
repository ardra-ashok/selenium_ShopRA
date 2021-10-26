package Objects;

import org.openqa.selenium.By;

public class ProceedToCheckOutObjects {
    public static By standardCheckOut = By.cssSelector(".center_column>.cart_navigation>.standard-checkout");
    public static By proceedAddressVerify = By.xpath("//div[@id='center_column']//form[@method='post']//button[@name='processAddress']");
    public static By agreeTermsConditions = By.xpath("//*[@id=\"cgv\"]");
    public static By proceedToPayments = By.xpath("//form[@method='post']//button[@name='processCarrier']");
    public static By chequeOption = By.cssSelector(".payment_module>.cheque");
    public static By confirmOrder = By.xpath("//p[@id='cart_navigation']//button[@type='submit']");
    public static By confirmMessage = By.xpath("//div[@id='center_column']/p[@class='alert alert-success']");
    public static By logOutButton = By.cssSelector("a.logout");
    public static By shoppingCart = By.xpath("//div[@class='shopping_cart']/a[@title='View my shopping cart']");
    public static By cartCheckout = By.xpath("//a[@title='Check out']");
}
