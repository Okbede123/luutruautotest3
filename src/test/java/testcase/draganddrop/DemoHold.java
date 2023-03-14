package testcase.draganddrop;

import cores.commons.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoHold extends BaseTest {

    WebDriver driver;

    int sizeX;
    int sizeY;

    Dimension dimension;

    Actions actions;

    @Parameters({"browser","osName","osVersion","port","ipAddress","environment","url"})
    @BeforeClass
    public void beforeClass(String browserName,String osName,String osVersion,String port,String ipAddress,String environment,String url){
        driver = openBrowser(environment,browserName,ipAddress,port,osName,osVersion,url);
        dimension = driver.manage().window().getSize();
        sizeX = dimension.width;
        sizeY = dimension.height;
        actions = new Actions(driver);
    }


    @Test
    public void TC_01() throws InterruptedException {
       WebElement scrollToThis = driver.findElement(By.xpath("//h2[text() = 'The Example']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",scrollToThis);
        WebElement circle = driver.findElement(By.xpath("//div[@id ='item']"));
        //release nha chuot
        actions.moveToElement(circle).clickAndHold().pause(Duration.ofSeconds(5)).release().perform();

    }
}
