package actions.pageobject;

import InterFaceUI.ProfilePageUI;
import cores.commons.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ProfilePageObject extends BasePage {
    Map<WebElement,Integer> stringIntegerMapFriend = new HashMap<>();
    Map<String,Integer> stringIntegerMap = new TreeMap<>();

    List<WebElement> myListFriend = new ArrayList<>();


    public ProfilePageObject(WebDriver driver) {
        super(driver);
    }



    public void getListFriend(int numberFriend){
        List<WebElement>getListFriend = getListElement(ProfilePageUI.FRIEND);
        if(getListFriend.size() < numberFriend){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",getListFriend.get(getListFriend.size()-1));
            for (WebElement friend:getListFriend) {
                stringIntegerMap.put(friend.getText(),1);
            }
            sleepInTime(1);
            getListFriend(numberFriend);
        }
        else {
            for (String friend:stringIntegerMap.keySet()) {
                System.out.println(friend);
            }
        }
    }

    public void clickToListFriend(){
        scrollByJs(ProfilePageUI.LIST_PICTURES);
        clickToElements(ProfilePageUI.CLICK_TO_SEE_LIST_FRIEND);
    }

    public List<WebElement> getListFriendFix(int numberFriend){
        if(stringIntegerMapFriend.keySet().size() <= numberFriend){
            List<WebElement>getListFriend = getListElement(ProfilePageUI.FRIEND);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",getListFriend.get(getListFriend.size()-1));
            for (WebElement friend:getListFriend) {
                stringIntegerMapFriend.put(friend,1);
            }
            getListFriendFix(numberFriend);
        }
        else {
            int count = 0;
            for (WebElement getFriend:stringIntegerMapFriend.keySet()) {
                if(count == numberFriend){
                    return myListFriend;
                }
                myListFriend.add(getFriend);
                count++;
            }
        }
        return myListFriend;
    }


    public void getListGroup(int numberGroup){
        if(stringIntegerMap.keySet().size() <= numberGroup){
            List<WebElement>getListFriend = getListElement(ProfilePageUI.GROUPS_PUBLIC);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",getListFriend.get(getListFriend.size()-1));
            for (WebElement friend:getListFriend) {
                stringIntegerMap.put(friend.getText(),1);
            }
            getListGroup(numberGroup);
        }
        else {
            int count = 0;
            for (String getFriend:stringIntegerMap.keySet()) {
                if(count == numberGroup){
                    break;
                }
                System.out.println(getFriend);
                count++;
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

    public NavigationPageObject goToNavigationPage(){
        return PageGeneralManager.openNavigationPage(driver);
    }


    public static class NavigationPageObject extends ProfilePageObject{
        public NavigationPageObject(WebDriver driver) {
            super(driver);
        }

        public void clickToFriend(){
            clickToElements(ProfilePageUI.NavigationPageUI.NAVIGATION_OPTIONS,"Bạn bè");
        }

        public void clickToMoreOptions(String chose){
            scrollByJs(ProfilePageUI.NavigationPageUI.NAVIGATION_MORE_OPTIONS);
            clickToElements(ProfilePageUI.NavigationPageUI.NAVIGATION_MORE_OPTIONS);
            switch (chose){
                case "Check in":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Thể thao":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Âm nhạc":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Phim":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Chương trình TV":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Sách":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Ứng dụng và trò chơi":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Thích":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Sự kiện":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Câu hỏi":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Bài đánh giá đã viết":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Nhóm":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                case "Quản lý các phần":{
                    clickToElements(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
                    break;
                }
                default:{
                    throw new RuntimeException();
                }
            }
        }
    }
}
