package InterFaceUI;

public class BaseUI {

    public static final String TEXT_BOX_COMMENT = "xpath=//div[text()='Viết bình luận...']//parent::div//div/p";

    public static final String TEXT_BOX_COMMENTED = "xpath=//span[text()='%s']//parent::p";

    public static final String KEY_TO_PRESS = "xpath=//div[text()='Viết bình luận...']";

    public static final String ICON_COMMENT = "xpath=//div[@aria-label='Viết bình luận']/div/div/i";

    public static final String EMOTION = "xpath=//span[text()='Thích']//parent::span//parent::div//parent::div//parent::div[@aria-label = 'Thích']";
}
