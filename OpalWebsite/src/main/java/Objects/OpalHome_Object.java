package Objects;

public class OpalHome_Object {
    private static TestProps testProps;
    public OpalHome_Object(TestProps testProps) {
        this.testProps = testProps;
    }

    public static final String url =  "";
    public static final By username_Input = By.id("h_username");
    public static final By password_Input = By.id("h_password");

    // Forgot password workflow
    public static final By forgotPassword = By.xpath("//a[@href='/login/forgotten-index']");
    public static final By retrievePasswordSmartCardInfoRd = By.id("reset-sc-info");
    public static final By retrievePasswordAccountDetails_Rd = By.id("reset-full-info");
    public static final By forgotPasswordUsername_Inp = By.id("username");
    public static final By forgotPasswordCardNumber_Inp = By.id("cardNumber");
    public static final By forgotPasswordSecurityCode_Inp = By.id("securityNumber");
    public static final By forgotPasswordEnterDetails_Btn = By.name("submit");
    public static final By forgotPasswordPin_Inp = By.id("pin");
    public static final By forgotPasswordAnswer_Inp = By.id("answer");
    public static final By forgotPasswordNewPassword_Inp = By.id("newPassword");
    public static final By forgotPasswordNewPasswordConfirm_Inp = By.id("confirmPassword");
    public static final By forgotPasswordLogin_Btn = By.xpath("//a[@href='../lightbox/homepage-login/check-registration']");

    public static final By loginFormUsername_Inp = By.id("username");
    public static final By LoginFormPassword_Inp = By.id("password");


}

