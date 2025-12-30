package steps;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import validators.NavigationValidator;


@Slf4j
public class NavigationSteps {

    private final NavigationValidator navigationValidator;

    public NavigationSteps() {
        WebDriver driver = CucumberHooks.getDriver();
        this.navigationValidator = new NavigationValidator(driver);
    }

    @Then("the products page should be visible")
    public void theProductsPageShouldBeVisible() {
        navigationValidator.validateProductsPageIsVisible();
    }

    @Then("the shopping cart should be visible")
    public void theShoppingCartShouldBeVisible() {
        navigationValidator.validateShoppingCartIsVisible();
    }
}
