package steps;

import helpers.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utilities.ConfigurationLoader;
import validators.LoginValidator;

@Slf4j
public class LoginSteps {

    private final WebDriverHelper webDriverHelper;
    private final LoginValidator loginValidator;
    private final ConfigurationLoader config;

    public LoginSteps() {
        WebDriver driver = CucumberHooks.getDriver();
        this.webDriverHelper = new WebDriverHelper(driver);
        this.loginValidator = new LoginValidator(driver);
        this.config = ConfigurationLoader.getInstance();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        log.info("Entering valid credentials");
        String username = config.getProperty("username");
        String password = config.getProperty("password");

        webDriverHelper.sendKeys(LoginPage.USER_LOGIN_INPUT, username);
        webDriverHelper.sendKeys(LoginPage.USER_PASSWORD_INPUT, password);
    }

    @When("the user enters invalid credentials")
    public void theUserEntersInvalidCredentials() {
        log.info("Entering invalid credentials");
        String wrongUsername = config.getProperty("wrong_username");
        String wrongPassword = config.getProperty("wrong_password");

        webDriverHelper.sendKeys(LoginPage.USER_LOGIN_INPUT, wrongUsername);
        webDriverHelper.sendKeys(LoginPage.USER_PASSWORD_INPUT, wrongPassword);
    }

    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        log.info("Entering username '{}' and password", username);
        webDriverHelper.sendKeys(LoginPage.USER_LOGIN_INPUT, username);
        webDriverHelper.sendKeys(LoginPage.USER_PASSWORD_INPUT, password);
    }

    @When("the user clicks on the Sign In button")
    public void theUserClicksOnTheSignInButton() {
        log.info("Clicking on Sign In button");
        webDriverHelper.clickElement(LoginPage.SIGN_IN_BUTTON);
    }

    @Then("the user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        loginValidator.validateUserIsLoggedIn();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        loginValidator.validateLoginError();
    }

    @Then("the user should not be logged in")
    public void theUserShouldNotBeLoggedIn() {
        loginValidator.validateUserIsNotLoggedIn();
    }
}
