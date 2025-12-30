package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class EdgeDriverManager extends DriverManager {

    @Override
    protected WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();

        return new EdgeDriver(getEdgeOptions());
    }

    private EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.NORMAL);
        return edgeOptions;
    }

}
