package driverManager;


public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {
        return switch (type) {
            case CHROME -> new ChromeDriverManager();
            case FIREFOX -> new FirefoxDriverManager();
            case EDGE -> new EdgeDriverManager();
        };
    }
}
