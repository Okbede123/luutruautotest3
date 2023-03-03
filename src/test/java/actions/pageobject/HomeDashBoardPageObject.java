package actions.pageobject;

import InterFaceUI.HomeDashBoardPageUI;
import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class HomeDashBoardPageObject extends BasePage {

    public HomeDashBoardPageObject(WebDriver driver) {
        super(driver);
    }

    public ProfilePageObject goToYourProfile(){
        clickToElements(HomeDashBoardPageUI.GOTO_YOUR_PROFILE);
        clickToElements(HomeDashBoardPageUI.MY_PROFILE);
        return PageGeneralManager.openProfilePage(driver);
    }

}
