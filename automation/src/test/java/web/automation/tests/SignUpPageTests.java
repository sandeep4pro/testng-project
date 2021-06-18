package web.automation.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import web.automation.pages.HomePage;
import web.automation.pages.SignUpPage;
import web.automation.utilities.PageObject;

public class SignUpPageTests extends PageObject {
    HomePage homePage = new HomePage();
    SignUpPage signUpPage = new SignUpPage();

    @Test(description = "User signups with valid credential", invocationCount = 1)
    public void signUpWithValidCredential() {
        homePage.clickOnSignUPButton();
        signUpPage.fillEmailId("abc@abc.com");
        Assert.assertEquals("A", "B");
    }
}
