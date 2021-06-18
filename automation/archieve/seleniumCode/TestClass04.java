package web.automation.seleniumCode;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass04 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.indiatoday.in/");
        System.out.println(driver.findElementByXPath("//*[contains(text(),'Top Stories')]//following::a[1]").getAttribute("title"));
    }
}
