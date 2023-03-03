package actions.pageobject;

import InterFaceUI.CheckPointPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckPointPageObject extends BasePage {

    public CheckPointPageObject(WebDriver driver) {
        super(driver);
    }

    public void inputPassAndSend(String passCheckPoint){
        sendKeys(CheckPointPageUI.PASS_CHECKPOINT,passCheckPoint);
        clickToElements(CheckPointPageUI.BUTTON_CHECKPOINT);
    }

    public HomeDashBoardPageObject chooseSaveBrowserOrNot(String chooseSaveOrNot){
        clickToElements(CheckPointPageUI.CHOOSE_SAVE_BROWSER_OR_NOT,chooseSaveOrNot);
        clickToElements(CheckPointPageUI.BUTTON_CHECKPOINT);
        return PageGeneralManager.openHomeDashBoard(driver);
    }

}
