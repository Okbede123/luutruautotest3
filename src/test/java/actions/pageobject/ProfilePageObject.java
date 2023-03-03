package actions.pageobject;

import InterFaceUI.ProfilePageUI;
import cores.commons.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProfilePageObject extends BasePage {

    public ProfilePageObject(WebDriver driver) {
        super(driver);
    }


    public void clickToListFriend(){
        scrollByJs(ProfilePageUI.LIST_PICTURES);
        clickToElements(ProfilePageUI.CLICK_TO_SEE_LIST_FRIEND);
    }


    public void getListFriend(){

        Map<String,Integer> stringIntegerMap = new TreeMap<>();
        List<WebElement>getListFriend = getListElement(ProfilePageUI.FRIEND);
        if(getListFriend.size() < 30){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",getListFriend.get(getListFriend.size()-1));
            for (WebElement friend:getListFriend) {
                stringIntegerMap.put(friend.getText(),1);
            }
            sleepInTime(1);
            getListFriend();
        }

        for (String friend:stringIntegerMap.keySet()) {
            if(stringIntegerMap.keySet().size() <= 30){
                System.out.println(friend);
                break;
            }

        }
    }




    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
