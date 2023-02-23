package testcase;

import cores.commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Testcase extends BaseTest {

    WebDriver driver;

    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){

        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
    }

    @Test
    public void TC_01(){
        System.out.println("test");
    }

    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
