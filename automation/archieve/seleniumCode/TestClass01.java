package web.automation.seleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Sandeep");
    }
}
