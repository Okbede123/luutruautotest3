package testcase.facebook;

import actions.pageobject.*;
import cores.commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AutoPostInGroup extends BaseTest {

    WebDriver driver;
    HomeDashBoardPageObject homeDashBoardPageObject;
    ProfilePageObject profilePageObject;

    LoginPageObject loginPageObject;
    CheckPointPageObject checkPointPageObject;


    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
        loginPageObject = PageGeneralManager.openLoginPage(driver);
        checkPointPageObject = loginPageObject.inPutUserAndPassAndLogin("0563886668","okbedenb77");
        checkPointPageObject.inputPassAndSend("561011");
        homeDashBoardPageObject = checkPointPageObject.chooseSaveBrowserOrNot("Lưu trình duyệt");
        homeDashBoardPageObject = PageGeneralManager.openHomeDashBoard(driver);
        profilePageObject = homeDashBoardPageObject.goToYourProfile();
    }

    @Test
    public void TC_01_PostInGroup(){
        profilePageObject.goToNavigationPage().clickToMoreOptions("Nhóm");
        profilePageObject.postInGroup(5,nameGroup(),postGroup());
    }


    public static ArrayList<String> nameGroup(){
        ArrayList<String>list = new ArrayList<>();
        list.add("CHỢ DÂN CƯ QUẬN HAI BÀ TRƯNG - HÀ NỘI");
        return list;
    }

    public static ArrayList<String> postGroup(){
        ArrayList<String>list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.add("test3");
        return list;
    }

}
