package steps;

import driverManager.DriverManagerFactory;
import driverManager.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * CucumberHooks - Manages test lifecycle with Cucumber
 * The @Before and @After execute before and after each scenario
 */
@Slf4j
public class CucumberHooks {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final int IMPLICIT_WAIT_TIMEOUT = 10;

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @Before
    public void setUp(Scenario scenario) {
        log.info("Starting scenario: {}", scenario.getName());
        WebDriver driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = driverThreadLocal.get();
        try {
            if (scenario.isFailed()) {
                log.error("Scenario '{}' failed", scenario.getName());
                takeScreenshot(scenario, driver);
            } else {
                log.info("Scenario '{}' completed successfully", scenario.getName());
            }
        } finally {
            if (driver != null) {
                driver.quit();
                driverThreadLocal.remove();
                log.info("WebDriver closed");
            }
        }
    }

    // When a test fails
    private void takeScreenshot(Scenario scenario, WebDriver driver) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String fileName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis() + ".png";
            File destFile = new File("target/screenshots/" + fileName);
            if(!destFile.getParentFile().mkdirs()) {
                log.error("Error creating directory for screenshots");
                return;
            }

            FileUtils.copyFile(scrFile, destFile);

            log.info("Screenshot saved: {}", destFile.getAbsolutePath());
        } catch (IOException e) {
            log.error("Error taking screenshot: {}", e.getMessage());
        }
    }

}
