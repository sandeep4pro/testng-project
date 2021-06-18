package web.automation.seleniumCode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass06 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.guru99.com/scroll-up-down-selenium-webdriver.html");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(15000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, - document.body.scrollHeight)");
    }
}
