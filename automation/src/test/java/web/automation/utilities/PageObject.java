package web.automation.utilities;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Objects;

public class PageObject extends Hooks {
    private static final Logger logger = LoggerFactory.getLogger(PageObject.class);

    protected final void openApplication(String url) {
        Objects.requireNonNull(getDriver()).navigate().to(url);
    }

    protected final void openApplication(URL url) {
        Objects.requireNonNull(getDriver()).navigate().to(url);
    }

    protected final void clickOnElement(By by) {
        logger.info("Click on element " + by);
        try {
            Listeners.test.log(Status.INFO, "Click on element " + by);
        } catch (Exception ignored) {
        }
        Objects.requireNonNull(getDriver()).findElement(by).click();
    }

    protected final void sendKeys(By by, String text) {
        logger.info("Enter text " + text + " in field " + by);
        try {
            Listeners.test.log(Status.INFO, "Enter text " + text + " in field " + by);
        } catch (Exception ignored) {
        }

        Objects.requireNonNull(getDriver()).findElement(by).sendKeys(text);
    }
}
