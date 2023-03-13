package actions.pageobject;

import InterFaceUI.BaseUI;
import InterFaceUI.ProfilePageUI;
import cores.commons.BasePage;
import org.apache.log.output.net.SocketOutputTarget;
import org.openqa.selenium.*;

import java.util.*;

public class ProfilePageObject extends BasePage {
    Map<WebElement,Integer> stringIntegerMapFriend = new HashMap<>();
    Map<String,Integer> stringIntegerMap = new TreeMap<>();
    List<WebElement> myListFriend = new ArrayList<>();


    int countFriendComment = 1;
    int count = 0;

    int countGroup = 0;
    int numberOfGroup = 1;


    public ProfilePageObject(WebDriver driver) {
        super(driver);
    }

    public void commentToFirstFriend(int numberFriend,ArrayList<String> listComment,List<String> linkFriendRemove){
        if(getListElement(ProfilePageUI.FRIEND).size() == countFriendComment){
            scrollByJsParameterWebElement(getListElement(ProfilePageUI.FRIEND).get(getListElement(ProfilePageUI.FRIEND).size()-1));
            sleepInTime(3);
        }
        while (countFriendComment < numberFriend){
            WebElement friend = getListElement(ProfilePageUI.FRIEND).get(countFriendComment);
            System.out.println(getListElement(ProfilePageUI.FRIEND).size() + " size");
            scrollByJsParameterWebElement(friend);
            clickByJsParaWebElement(friend);
            while (countFriendComment <= numberFriend){
                try {
                    sleepInTime(2);
                    int number = getRandom(listComment.size()-1);
                    sleepInTime(2);
                    scrollByJs(BaseUI.KEY_TO_PRESS);
                    clickByJs(BaseUI.KEY_TO_PRESS);
                    sleepInTime(2);
                    sendKeys(BaseUI.TEXT_BOX_COMMENT,listComment.get(number));
                    sendKeys(BaseUI.TEXT_BOX_COMMENTED,Keys.ENTER,listComment.get(number));
                    sleepInTime(1);
                    break;
                }catch (TimeoutException e){

                }
            }
            countFriendComment++;
            backPage();
            commentToFirstFriend(numberFriend,listComment,linkFriendRemove);
        }
    }

    public void commentToFirstFriendRefactor(int numberFriend,ArrayList<String> listComment,List<String> linkFriendRemove, int postToComment){
        while (count <= numberFriend){
            for (String friendNotComment:linkFriendRemove) {
                if(getElement(ProfilePageUI.LINK_FRIEND,String.valueOf(countFriendComment)).getAttribute("href").contains(friendNotComment)){
                    countFriendComment++;
                    sleepInTime(3);
                    commentToFirstFriendRefactor(numberFriend,listComment,linkFriendRemove,postToComment);
                }
            }
            if(count == numberFriend){
                break;
            }
            sleepInTime(2);
            scrollByJs(ProfilePageUI.LINK_FRIEND,String.valueOf(countFriendComment));
            sleepInTime(2);
            clickByJs(ProfilePageUI.LINK_FRIEND,String.valueOf(countFriendComment));
            while (count <= numberFriend){
                    commentToFriend(BaseUI.KEY_TO_PRESS,BaseUI.TEXT_BOX_COMMENT,BaseUI.TEXT_BOX_COMMENTED,listComment,postToComment);
                    break;
            }
            sleepInTime(1);
            countFriendComment++;
            backPage();
            sleepInTime(3);
            count++;
            System.out.println(count);
            commentToFirstFriendRefactor(numberFriend,listComment,linkFriendRemove,postToComment);

        }
    }


    public void commentToFriend(String locatorToPress,String textBoxComment,String PressEnter,List<String>listComment,int postToComment){
        for (int i = 1; i <= postToComment ; i++) {
            sleepInTime(2);
            int number = getRandom(listComment.size()-1);
            sleepInTime(2);
            scrollByJs(locatorToPress,String.valueOf(i));
            clickByJs(locatorToPress,String.valueOf(i));
            sleepInTime(2);
            sendKeys(textBoxComment,listComment.get(number),String.valueOf(i));
            sleepInTime(2);
            sendKeys(PressEnter,Keys.ENTER,listComment.get(number),"1");
            sleepInTime(1);
        }
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


    public void postInGroup(int numberGroup,List<String> linkContain){
        while (countGroup<=numberGroup){
            sleepInTime(3);
            System.out.println("so lan thanh cong "+ countGroup);
            for (String link:linkContain) {
                System.out.println("test vao vong lap for");
                if(getElement(ProfilePageUI.GROUPS_PUBLIC_COUNT,String.valueOf(numberOfGroup)).getText().equalsIgnoreCase(link)){
                    clickByJs(ProfilePageUI.GROUPS_PUBLIC_COUNT,String.valueOf(numberOfGroup));
                    sleepInTime(3);
                    System.out.println("xu ly comment hoac dang bai trong nay");
                    countGroup++;
                    backPage();
                    break;
                }
            }
            System.out.println("test vao day gia tri ten cua group "+ getElement(ProfilePageUI.GROUPS_PUBLIC_COUNT,String.valueOf(numberOfGroup)).getText() + " gia tri count la "+ numberOfGroup);
            sleepInTime(2);
            numberOfGroup++;
            sleepInTime(2);
            scrollByJs(ProfilePageUI.GROUPS_PUBLIC_COUNT,String.valueOf(numberOfGroup));
        }
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
            scrollByJs(ProfilePageUI.NavigationPageUI.MORE_OPTIONS_CHOOSE,chose);
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
