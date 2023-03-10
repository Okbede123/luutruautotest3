package testcase;

import actions.pageobject.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;
import java.util.List;

public class Testcase extends BaseTest {


    LoginPageObject loginPageObject;
    CheckPointPageObject checkPointPageObject;
    HomeDashBoardPageObject homeDashBoardPageObject;
    ProfilePageObject profilePageObject;
    ProfilePageObject.NavigationPageObject navigationPageObject;

//    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
//    @BeforeClass
//    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
//        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
//        loginPageObject = PageGeneralManager.openLoginPage(driver);
//        checkPointPageObject = loginPageObject.inPutUserAndPassAndLogin("0563886668","okbedenb77");
//        checkPointPageObject.inputPassAndSend("608509");
//        homeDashBoardPageObject = checkPointPageObject.chooseSaveBrowserOrNot("Lưu trình duyệt");
//    }

    @BeforeMethod
    public void beforeMethod(Method method){
        ExtentManager.startTest(method.getName(),"Go to profile");
        ExtentManager.getTest().log(Status.INFO,"check go to profile");
        homeDashBoardPageObject = PageGeneralManager.openHomeDashBoard(LoginFirst.driver);
        profilePageObject = homeDashBoardPageObject.goToYourProfile();
    }

    @Test
    public void TC_02_GetListFriend(){
        profilePageObject.clickToListFriend();
        profilePageObject.getListFriendFix(30);
    }

    //@Test
    public void TC_03_GetListGroup(){
        profilePageObject.refreshPage();
        navigationPageObject =  profilePageObject.goToNavigationPage();
        navigationPageObject.clickToMoreOptions("Nhóm");
        profilePageObject.getListGroup(30);
    }

    //@AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }
}
