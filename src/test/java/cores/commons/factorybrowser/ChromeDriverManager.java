package cores.commons.factorybrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChromeDriverManager implements FactoryBrowser {
    @Override
    public WebDriver getBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
