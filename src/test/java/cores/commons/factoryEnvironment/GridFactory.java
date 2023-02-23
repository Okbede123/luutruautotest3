package cores.commons.factoryEnvironment;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {
    WebDriver driver;
    private String browserName;
    private String ipAddress;
    private String portNumber;

    public GridFactory(String browserName,String ipAddress,String portNumber){
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
    }

    public WebDriver getDriver(){
        DesiredCapabilities capabilities = null;
        Platform platform = Platform.ANY;

        switch (browserName){
            case "chrome":{
                capabilities = DesiredCapabilities.chrome();
                capabilities.setBrowserName("chrome");
                capabilities.setPlatform(platform);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(capabilities);
                break;
            }
            case "firefox":{
                capabilities = DesiredCapabilities.firefox();
                capabilities.setBrowserName("firefox");
                capabilities.setPlatform(platform);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.merge(capabilities);
                break;
            }
            default:
                throw new RuntimeException("Browser is not valid");
        }
            try {
                driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub",ipAddress,portNumber)),capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        return driver;
    }
}
