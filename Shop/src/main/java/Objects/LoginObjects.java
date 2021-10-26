package Objects;

import org.openqa.selenium.By;

public class LoginObjects {
    public static By emailField = By.id("email");
    public static By passwordField = By.id("passwd");
    public static By loginButton = By.id("SubmitLogin");
    public static By textField = By.cssSelector("a.account");
    public static By errorMessage = By.xpath("//*[@id='center_column']/div[1]/ol/li");
    public static By goLoginPage = By.cssSelector("a.login");
}
