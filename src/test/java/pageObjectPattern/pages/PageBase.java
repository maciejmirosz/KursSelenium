package pageObjectPattern.pages;

import org.openqa.selenium.WebElement;

public abstract class PageBase {

    protected void sendKeys(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
