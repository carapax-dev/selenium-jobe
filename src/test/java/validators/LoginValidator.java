package validators;

import helpers.WebDriverHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class LoginValidator {

    private final WebDriverHelper webDriverHelper;

    public LoginValidator(WebDriver driver) {
        this.webDriverHelper = new WebDriverHelper(driver);
    }

    public void validateUserIsLoggedIn() {
        log.info("Validating user is logged in");
        boolean isLoggedIn = webDriverHelper.isElementVisible(ProductsPage.INVENTORY_CONTAINER);
        assertThat("User is not logged in correctly", isLoggedIn, is(true));
    }

    public void validateLoginError() {
        log.info("Validating login error is displayed");
        boolean errorDisplayed = webDriverHelper.isElementVisible(LoginPage.ERROR_ALERT);
        assertThat("Expected error message was not displayed", errorDisplayed, is(true));
    }

    public void validateUserIsNotLoggedIn() {
        log.info("Validating user is NOT logged in");
        boolean isOnLoginPage = webDriverHelper.isElementVisible(LoginPage.SIGN_IN_BUTTON);
        assertThat("User is logged in when they should not be", isOnLoginPage, is(true));
    }
}
