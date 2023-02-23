package cores.commons.factoryEnvironment;

import cores.commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackFactory {

    WebDriver driver;
    private String browserName;
    private String osName;
    private String osVersion;

    public BrowserStackFactory(String browserName,String osName,String osVersion){
        this.browserName = browserName;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    public WebDriver getDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os","osName");
        capabilities.setCapability("osVersion",osVersion);
        capabilities.setCapability("browser",browserName);
        capabilities.setCapability("browserVersion","latest");
        capabilities.setCapability("project","");
        capabilities.setCapability("resolution","1920x1080");
        capabilities.setCapability("name","Run on "+osName+" | "+ osVersion+ " | "+ browserName);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstant.BROWSER_STACK_URL),capabilities);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }

}
