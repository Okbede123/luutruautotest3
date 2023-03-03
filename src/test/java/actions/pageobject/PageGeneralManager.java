package actions.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGeneralManager {


    public static LoginPageObject openLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static CheckPointPageObject openCheckPointPage(WebDriver driver){
        return new CheckPointPageObject(driver);
    }

    public static HomeDashBoardPageObject openHomeDashBoard(WebDriver driver){
        return new HomeDashBoardPageObject(driver);
    }

    public static ProfilePageObject openProfilePage(WebDriver driver){
        return new ProfilePageObject(driver);
    }
}
