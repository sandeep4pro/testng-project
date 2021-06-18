package web.automation.seleniumCode;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestClass05 {
    public static void main(String[] args) throws Exception {
//        Logger logger = Logger.getLogger("");
//        logger.setLevel(Level.OFF);
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_68);
        driver.get("https://www.guru99.com/gecko-marionette-driver-selenium.html");
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("./screenshots/test.png"));
//        JavascriptExecutor javascript = (JavascriptExecutor) driver;
//        String pagetitle = (String) javascript.executeScript("return document.title");
//        System.out.println("My Page Title Is  : " + pagetitle);
//        File file = new File("./drivers/phantomjs.exe");
//        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
//        WebDriver driver = new PhantomJSDriver();
//        driver.get("https://www.guru99.com/gecko-marionette-driver-selenium.html");
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("./screenshots/test.png"));
        System.out.println("execution finished");
        driver.quit();
    }
}
