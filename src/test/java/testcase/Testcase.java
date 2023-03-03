package testcase;

import actions.pageobject.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;
import java.util.List;

public class Testcase extends BaseTest {

    WebDriver driver;
    LoginPageObject loginPageObject;
    CheckPointPageObject checkPointPageObject;
    HomeDashBoardPageObject homeDashBoardPageObject;
    ProfilePageObject profilePageObject;

    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
        loginPageObject = PageGeneralManager.openLoginPage(driver);
    }

    @Test
    public void TC_01_Login(Method method){
        ExtentManager.startTest(method.getName(),"TC_01");
        ExtentManager.getTest().log(Status.INFO,"check login facebook");
        checkPointPageObject = loginPageObject.inPutUserAndPassAndLogin("0563886668","okbedenb77");
        checkPointPageObject.inputPassAndSend("460689");
        homeDashBoardPageObject = checkPointPageObject.chooseSaveBrowserOrNot("Lưu trình duyệt");
        profilePageObject = homeDashBoardPageObject.goToYourProfile();

    }

    @Test
    public void TC_02_GetListFriend(){
        profilePageObject.clickToListFriend();
        profilePageObject.getListFriend();
    }

    //@AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
