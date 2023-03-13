package testcase.facebook;

import actions.pageobject.*;
import cores.commons.BasePage;
import cores.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LoginFirst extends BaseTest {

    public static WebDriver driver;

    LoginPageObject loginPageObject;
    CheckPointPageObject checkPointPageObject;
    HomeDashBoardPageObject homeDashBoardPageObject;


    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeTest
    public void beforeTest(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
        loginPageObject = PageGeneralManager.openLoginPage(driver);
        checkPointPageObject = loginPageObject.inPutUserAndPassAndLogin("0563886668","okbedenb77");
        checkPointPageObject.inputPassAndSend("010282");
        homeDashBoardPageObject = checkPointPageObject.chooseSaveBrowserOrNot("Lưu trình duyệt");
    }
}
