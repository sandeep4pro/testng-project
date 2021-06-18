package web.automation.pages;

import org.openqa.selenium.By;
import web.automation.utilities.PageObject;

public class HomePage extends PageObject {
    private String signUpButton = "a[title='register on freecrm.com']";

    public void clickOnSignUPButton() {
        clickOnElement(By.cssSelector(signUpButton));
    }
}
