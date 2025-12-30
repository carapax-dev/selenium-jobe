package validators;

import helpers.WebDriverHelper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import pages.CartPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class NavigationValidator {

    private final WebDriverHelper webDriverHelper;

    public NavigationValidator(WebDriver driver) {
        this.webDriverHelper = new WebDriverHelper(driver);
    }

    public void validateProductsPageIsVisible() {
        log.info("Validating Products page is visible");
        boolean isVisible = webDriverHelper.isElementVisible(ProductsPage.INVENTORY_CONTAINER);
        assertThat("Products page is not visible", isVisible, is(true));
    }

    public void validateShoppingCartIsVisible() {
        log.info("Validating Shopping Cart is visible");
        boolean isVisible = webDriverHelper.isElementVisible(CartPage.CART_LIST);
        assertThat("Shopping Cart is not visible", isVisible, is(true));
    }
}
