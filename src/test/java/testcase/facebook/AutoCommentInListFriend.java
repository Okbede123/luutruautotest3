package testcase.facebook;

import actions.pageobject.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class AutoCommentInListFriend extends BaseTest {

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
        checkPointPageObject.inputPassAndSend("872764");
        homeDashBoardPageObject = checkPointPageObject.chooseSaveBrowserOrNot("Lưu trình duyệt");
        homeDashBoardPageObject = PageGeneralManager.openHomeDashBoard(driver);
        profilePageObject = homeDashBoardPageObject.goToYourProfile();
    }

    @Test
    public void TC_01_CommentToFirstFriend(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_CommentToFirstFriend");
        ExtentManager.getTest().log(Status.INFO,"check comment");
        profilePageObject.goToNavigationPage().clickToFriend();
        profilePageObject.commentToFriendRefactor(10,listComment(),listFriendRemove(),2);
    }


    public ArrayList<String> listComment(){
        ArrayList<String>list = new ArrayList<>();
        list.add("tương tác tốt");
        list.add("tương tác tốt cùng Đức Thần Tài");
        return list;
    }

    public static ArrayList<String> listFriendRemove(){
        ArrayList<String>list = new ArrayList<>();
        list.add("https://www.facebook.com/quynhhoachinny");
        list.add("https://www.facebook.com/hoang.nhat.353");
        list.add("https://www.facebook.com/ngocbich.nguyen686");
        list.add("https://www.facebook.com/haianh1012");
        list.add("https://www.facebook.com/doantmylinh");
        list.add("https://www.facebook.com/trangtm91");
        list.add("https://www.facebook.com/ThanhWL96");
        list.add("https://www.facebook.com/QuangKiri");
        return list;
    }
}
