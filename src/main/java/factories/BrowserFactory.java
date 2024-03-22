package factories;

import driver.DriverManager;
import enums.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    protected static void initBrowser(BrowserType browserType) {
        switch (browserType) {
            case FireFox:
               /* WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
                break;*/
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en");
                DriverManager.setDriver(new ChromeDriver(options));
                break;
            case EDGE:
                /*WebDriverManager.edgedriver().setup();
                DriverManager.setDriver(new EdgeDriver());*/
                break;
        }
    }
}
