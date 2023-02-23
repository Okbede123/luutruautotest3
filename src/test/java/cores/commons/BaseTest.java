package cores.commons;

import cores.commons.factoryEnvironment.BrowserStackFactory;
import cores.commons.factoryEnvironment.GridFactory;
import cores.commons.factoryEnvironment.LocalFactory;
import cores.commons.factorybrowser.ChromeDriverManager;
import cores.commons.factorybrowser.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

public class BaseTest {
    WebDriver driver;
    String env;

    public WebDriver getDriver(){
        return driver;
    }


    public WebDriver openBrowser(String env,String browserName,String ipAddress,String portNumber,String osName,String osVersion,String url){
        switch (env){
            case "local":{
                driver = new LocalFactory(browserName).getDriver();
                break;
            }
            case "grid":{
                driver = new GridFactory(browserName,ipAddress,portNumber).getDriver();
                break;
            }
            case "browserstack":{
                driver = new BrowserStackFactory(browserName,osName,osVersion).getDriver();
                break;
            }
        }
        driver.manage().window().maximize();
        driver.get(url);
        this.env = env;
        return driver;
    }

    protected void closeBrowserDriver(){
        if(env.equals("local") || env.equals("grid")){
            String cmd = null;
            try {
                String osName = GlobalConstant.OS_NAME;
                String driverInstanceName = driver.toString().toLowerCase();
                String browserDriverName = null;
                if(driverInstanceName.contains("chrome")){
                    browserDriverName = "chromedriver";
                } else if (driverInstanceName.contains("internetexplorer")) {
                    browserDriverName = "IEDriverServer";
                }else if (driverInstanceName.contains("firefox")) {
                    browserDriverName = "geckodriver";
                }else if (driverInstanceName.contains("edge")) {
                    browserDriverName = "msedgedriver";
                }else {
                    browserDriverName = "safaridriver";
                }

                if(osName.contains("Windows")){
                    cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
                } else {
                    cmd = "pkill " + browserDriverName;
                }
                if(driver != null){
                    driver.manage().deleteAllCookies();
                    driver.quit();
                }
         }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                try {
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                }catch (IOException e){
                    e.printStackTrace();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public int getRandomNum(){
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
