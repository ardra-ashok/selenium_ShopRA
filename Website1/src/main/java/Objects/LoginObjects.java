package Objects;

import org.openqa.selenium.By;

public class LoginObjects {
    public static By emailField = By.id("email");
    public static By passwordField = By.id("passwd");
    public static By loginButton = By.xpath("//button[@id='SubmitLogin']");
    public static By textField = By.cssSelector("a.account");
    public static By errorMessage = By.xpath("//*[@id='center_column']/*/ol/li");
    public static By logoutButton = By.cssSelector("a.logout");
    public static By linkTextWomen =  By.linkText("WOMEN");
}
