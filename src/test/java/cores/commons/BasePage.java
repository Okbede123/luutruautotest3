package cores.commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String castParameter(String value1,String...values){
        return String.format(value1,values);
    }

    public void clickToElements(String locator,String...values){
        waitElementClick(locator,values);
        getElement(locator,values).click();
    }

    public void sendKeys(String locator,String valueToSend,String...values){
        waitElementVisibility(locator,values);
        getElement(locator,values).sendKeys(valueToSend);
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public String getText(String locator,String...values){
        waitElementVisibility(locator,values);
        return getElement(locator,values).getText();
    }

    public WebElement getElement(String locator,String...values){
        return driver.findElement(getByLocator(castParameter(locator,values)));
    }

    public List<WebElement> getListElement(String locator,String...values){
        return driver.findElements(getByLocator(castParameter(locator,values)));
    }

    public By getByLocator(String locator){
        By getBy;
        if(locator.startsWith("Xpath=")||locator.startsWith("XPATH=")||locator.startsWith("xpath=")){
            getBy = By.xpath(locator.substring(6));
        } else if (locator.startsWith("class=")||locator.startsWith("CLASS=")||locator.startsWith("Class=")) {
            getBy = By.className(locator.substring(6));
        } else if (locator.startsWith("name=")||locator.startsWith("NAME=")||locator.startsWith("Name=")) {
            getBy = By.name(locator.substring(5));
        }else if(locator.startsWith("CSS=")||locator.startsWith("Css=")|| locator.startsWith("css=")){
            getBy = By.cssSelector(locator.substring(4));
        }else if(locator.startsWith("ID=")||locator.startsWith("Id=")|| locator.startsWith("id=")){
            getBy = By.id(locator.substring(3));
        }else {
            throw new RuntimeException("Locator not valid");
        }
        return getBy;
    }

    public Set<Cookie> setCookies(){
        return driver.manage().getCookies();
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void addCookies(Set<Cookie> cookies){
        for (Cookie cookie:cookies) {
            driver.manage().addCookie(cookie);
        }
        refreshPage();
    }

    public boolean isElementDisplay(String locator,String values){
        return getElement(locator,values).isDisplayed();
    }

    public boolean isElementNotDisplay(String locator,String values){
        boolean check;
        if (getListElement(locator,values).size() == 0){
            System.out.println("element not in dom");
            check = true;
        } else if (getListElement(locator,values).size() > 0 && !isElementDisplay(locator,values)) {
            System.out.println("element in dom and not display");
            check = true;
        }else if(getListElement(locator,values).size()> 0){
            System.out.println("element in dom and display");
            check = false;
        }else {
            return false;
        }
        return check;
    }

    public void clickByJs(String locator,String... values){
        waitElementClick(locator,values);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",getElement(locator,values));
    }

    public void scrollByJs(String locator,String...values){
        waitElementClick(locator,values);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",getElement(locator,values));
    }

    public void removeAttribute(String locator,String attribute,String...values){
        ((JavascriptExecutor)driver).executeScript("argument[0].removeAttribute('" + attribute + "')",getElement(locator,values));
    }

    public void waitElementClick(String locator,String...values){
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(getByLocator(castParameter(locator,values))));
    }

    public void waitElementVisibility(String locator,String...values){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParameter(locator,values))));
    }

    public void waitElementInvisibility(String locator,String...values){
        new WebDriverWait(driver,5).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParameter(locator,values))));
    }

    public void waitListElementVisibility(String locator,String...values){
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElements(getListElement(locator,values)));
    }

    public void switchToWindow(String id){
        driver.switchTo().window(id);
    }

    public Set<String> getListWindowHandles(){
        return driver.getWindowHandles();
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public String getTitle(){
       return driver.getTitle();
    }

    public void switchWindowTabs(String titleExpected){
        Set<String> allTabs = getListWindowHandles();
        if(allTabs.size()>1){
            for (String tab:allTabs) {
                switchToWindow(tab);
                if(getTitle().equals(titleExpected)){
                    break;
                }
            }
        }
    }

    public void switchWindowById(){
        String idPresent = getWindowHandle();
        Set<String>allTabs = getListWindowHandles();
        if(allTabs.size() > 1){
            for (String tab:allTabs) {
                switchToWindow(tab);
                if(!tab.equals(idPresent)){
                    break;
                }
            }
        }
    }

}
