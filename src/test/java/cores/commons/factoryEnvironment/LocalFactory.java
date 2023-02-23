package cores.commons.factoryEnvironment;

import cores.commons.factorybrowser.ChromeDriverManager;
import cores.commons.factorybrowser.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalFactory {

    WebDriver driver;
    String browserName;

    public LocalFactory(String browserName){
        this.browserName = browserName;
    }


    public WebDriver getDriver(){
        switch (browserName){
            case "chrome":{
            driver = new ChromeDriverManager().getBrowser();
            break;
            }
            case "firefox":{
                driver = new FirefoxDriverManager().getBrowser();
                break;
            }
            default:{
                System.out.println("not found driver");
                break;
            }
        }
        return driver;
    }
}
