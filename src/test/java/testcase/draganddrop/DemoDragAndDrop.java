package testcase.draganddrop;

import cores.commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoDragAndDrop extends BaseTest {
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

    //@Test
    public void TC_01_DragAndDrop(){
        sleepInTime(3);
       WebElement drag = driver.findElement(By.xpath("//div[@Id ='draggable']"));
       WebElement drop = driver.findElement(By.xpath("//div[@Id ='droptarget']"));
        actions.dragAndDrop(drag,drop).release().perform();

    }

    //@Test
    public void TC_02_moveToElement(){
        sleepInTime(3);
        WebElement drag = driver.findElement(By.xpath("//div[@Id ='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@Id ='droptarget']"));
        actions.moveToElement(drag).clickAndHold().moveToElement(drop).release().perform();

    }

    @Test
    public void TC_03_moveToElement(){
        sleepInTime(3);
        WebElement drag = driver.findElement(By.xpath("//div[@Id ='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@Id ='droptarget']"));
        actions.moveToElement(drag).clickAndHold().pause(Duration.ofSeconds(6)).moveToElement(drop).release().perform();

    }
}
