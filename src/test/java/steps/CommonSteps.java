package steps;

import helpers.NavigationHelper;
import helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

@Slf4j
public class CommonSteps {

    private final NavigationHelper navigationHelper;
    private final WebDriverHelper webDriverHelper;

    public CommonSteps() {
        WebDriver driver = CucumberHooks.getDriver();
        this.navigationHelper = new NavigationHelper(driver);
        this.webDriverHelper = new WebDriverHelper(driver);
    }

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {
        log.info("Navigating to home page (login page)");
        navigationHelper.navigateToHomePage();
    }

    @When("the user clicks on the shopping cart")
    public void theUserClicksOnTheShoppingCart() {
        log.info("Clicking on shopping cart");
        webDriverHelper.clickElement(ProductsPage.SHOPPING_CART_LINK);
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        log.info("Adding backpack to cart");
        webDriverHelper.clickElement(ProductsPage.ADD_TO_CART_BACKPACK);
    }
}
