package web.automation.pages;

import org.openqa.selenium.By;

import web.automation.utilities.PageObject;

public class SignUpPage extends PageObject {

    private String emailAddress = "input#email";

    public void fillEmailId(String email) {
        sendKeys(By.cssSelector(emailAddress), email);
    }
}
