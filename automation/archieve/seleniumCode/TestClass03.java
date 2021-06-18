package web.automation.seleniumCode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass03 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.findElementByName("q").sendKeys("sandeep");
        ((JavascriptExecutor) driver).executeScript("history.go(0)");
    }
}
