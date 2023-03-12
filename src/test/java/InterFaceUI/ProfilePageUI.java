package InterFaceUI;

public class ProfilePageUI {

    public static final String CLICK_TO_SEE_LIST_FRIEND = "xpath=//span[text() ='Xem tất cả bạn bè']";

    public static final String LIST_PICTURES = "xpath=//a[text() ='Ảnh']";

    public static final String FRIEND = "xpath=//div[@aria-label = 'Bạn bè']//parent::div//parent::div//parent::div//preceding-sibling::div//a/span[@dir ='auto']//parent::a";

    public static final String LINK_FRIEND = "xpath=(//div[@aria-label = 'Bạn bè']//parent::div//parent::div//parent::div//preceding-sibling::div//a/span[@dir ='auto']//parent::a)[%s]";

    public static final String GROUPS_PUBLIC = "xpath=//div[text()='Nhóm Công khai']//parent::div//parent::div//parent::div//parent::span//parent::div//parent::div//a//span";



    public class NavigationPageUI{

        public static final String NAVIGATION_OPTIONS = "xpath=//span[text()='%s']//parent::div//parent::a";
        public static final String NAVIGATION_MORE_OPTIONS = "xpath=(//span[text()='Xem thêm']//parent::div//parent::div)[1]";
        public static final String MORE_OPTIONS_CHOOSE = "xpath=//span[text()='%s']//parent::div";

    }
}
