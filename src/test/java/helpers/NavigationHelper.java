package helpers;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utilities.ConfigurationLoader;

@Slf4j
public class NavigationHelper {

    private final WebDriver driver;
    private final WebDriverHelper webDriverHelper;
    private final ConfigurationLoader config;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
        this.webDriverHelper = new WebDriverHelper(driver);
        this.config = ConfigurationLoader.getInstance();
    }

    public void navigateToUrl(String url) {
        try {
            log.info("Navigating to: {}", url);
            driver.get(url);
            webDriverHelper.waitForPageToLoad();
        } catch (TimeoutException e) {
            log.warn("Timeout navigating to URL: {}. Check test server", url);
            throw e;
        }
    }

    public void navigateToHomePage() {
        String baseUrl = config.getProperty("baseUrl");
        navigateToUrl(baseUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void refreshPage() {
        log.info("Refreshing page");
        driver.navigate().refresh();
        webDriverHelper.waitForPageToLoad();
    }

    public void goBack() {
        log.info("Navigating back");
        driver.navigate().back();
        webDriverHelper.waitForPageToLoad();
    }
}
