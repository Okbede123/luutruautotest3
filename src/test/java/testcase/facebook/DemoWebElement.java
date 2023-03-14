package testcase.facebook;

import actions.pageobject.*;
import cores.commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DemoWebElement extends BaseTest {

    WebDriver driver;
    HomeDashBoardPageObject homeDashBoardPageObject;
    ProfilePageObject profilePageObject;

    LoginPageObject loginPageObject;
    CheckPointPageObject checkPointPageObject;

    Set<WebElement>saveMap = new HashSet<>();
    List<WebElement>list = new ArrayList<>();


    @Parameters({"browser", "osName", "osVersion", "port", "ipAddress", "environment", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String osName, String osVersion, String port, String ipAddress, String environment, String url) {
        driver = openBrowser(environment, browserName, ipAddress, port, osName, osVersion, url);
        loginPageObject = PageGeneralManager.openLoginPage(driver);
        checkPointPageObject = loginPageObject.inPutUserAndPassAndLogin("0563886668", "okbedenb77");
        checkPointPageObject.inputPassAndSend("521447");
        homeDashBoardPageObject = checkPointPageObject.chooseSaveBrowserOrNot("Lưu trình duyệt");
        homeDashBoardPageObject = PageGeneralManager.openHomeDashBoard(driver);
        profilePageObject = homeDashBoardPageObject.goToYourProfile();
    }

    //@Test
    public void TC_01DemoWebElement() {
        profilePageObject.goToNavigationPage().clickToFriend();
         WebElement element =  driver.findElement(By.xpath("//span[text() ='Thêm vào tin']"));
        System.out.println(element.hashCode() + " luc chua luu vao set");
        saveMap.add(element);
        list.add(element);
        for (WebElement e:saveMap) {
            System.out.println(e.hashCode() + " luc luu vao set");
        }
        for (WebElement e:list) {
            System.out.println(e.hashCode() + " luc luu vao list");
        }
        sleepInTime(2);
        driver.get("https://dantri.com.vn/");

        sleepInTime(2);
        driver.get("https://www.facebook.com/ducthantai6668/friends");
        sleepInTime(2);
        element =  driver.findElement(By.xpath("//span[text() ='Thêm vào tin']"));

        System.out.println(element.hashCode() + " luc element reload chua luu vao set");
        saveMap.add(element);
        list.add(element);
        for (WebElement e:saveMap) {
            System.out.println(e.hashCode() + " luc element reload luu vao set lan 2");
        }
        for (WebElement e:list) {
            System.out.println(e.hashCode() + " luc luu vao list lan 2");
        }
    }

    @Test
    public void TC_03(){
        profilePageObject.goToNavigationPage().clickToFriend();
        List<WebElement> list1 = driver.findElements(By.xpath("//div[@aria-label = 'Bạn bè']//parent::div//parent::div//parent::div//preceding-sibling::div//a/span[@dir ='auto']//parent::a"));
        for (WebElement friend:list1) {
            System.out.println(friend.hashCode() + "  "+ friend.getText() + " lan dau");
        }
        sleepInTime(2);
        driver.get("https://dantri.com.vn/");

        sleepInTime(2);
        driver.get("https://www.facebook.com/ducthantai6668/friends");
        sleepInTime(2);

        list1 = driver.findElements(By.xpath("//div[@aria-label = 'Bạn bè']//parent::div//parent::div//parent::div//preceding-sibling::div//a/span[@dir ='auto']//parent::a"));
        for (WebElement friend:list1) {
            System.out.println(friend.hashCode() + "  "+ friend.getText() + " lan 2");
        }
    }
}
