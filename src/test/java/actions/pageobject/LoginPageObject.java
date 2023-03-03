package actions.pageobject;

import InterFaceUI.CheckPointPageUI;
import InterFaceUI.LoginPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    public CheckPointPageObject inPutUserAndPassAndLogin(String userName, String password){
        sendKeys(LoginPageUI.USER_NAME,userName);
        sendKeys(LoginPageUI.PASSWORD,password);
        clickToElements(LoginPageUI.BUTTON_LOGIN);
        return PageGeneralManager.openCheckPointPage(driver);
    }

}
