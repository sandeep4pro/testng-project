package web.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

public class ScreenshotGenerator extends Hooks {

    public static String captureScreenshot() {
        String screenshotPath = "";
        try {
            File screenshot = ((TakesScreenshot) Objects.requireNonNull(getDriver())).getScreenshotAs(OutputType.FILE);
            screenshotPath = System.getProperty("user.dir") + "\\target\\screenshots\\" + UUID.randomUUID() + ".jpg";
            FileUtils.copyFile(screenshot, new File(screenshotPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
}
