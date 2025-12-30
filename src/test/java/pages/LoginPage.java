package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By USER_LOGIN_INPUT = By.id("user-name");
    public static final By USER_PASSWORD_INPUT = By.id("password");
    public static final By SIGN_IN_BUTTON = By.id("login-button");
    public static final By ERROR_ALERT = By.cssSelector("[data-test='error']");
    public static final By ERROR_BUTTON = By.className("error-button");

    private LoginPage() {
    }
}
