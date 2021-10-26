package Objects;

import org.openqa.selenium.By;

public class ShopObjects {
    public static By linkTextWomen =  By.linkText("WOMEN");
    public static By availabilityStatus = By.cssSelector(".right-block>.availability>.available-now");
    public static By viewMoreButton = By.cssSelector(".right-block>.button-container>a:nth-of-type(2)");
    public static By plusButton = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']");
    public static By minusButton = By.xpath("//a[@class='btn btn-default button-minus product_quantity_down']");
    public static By addToCartButton = By.xpath("//button[@type='submit'][contains(.,'Add to cart')]");
    public static By continueButton = By.xpath("//span[@title='Continue shopping']");
    public static By selectSizeId = By.id("group_1");
    public static String availableQuery = "In stock";
}
