package web.automation.seleniumCode;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TestClass02 {

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ndtv.com/");
        List<WebElement> elements = driver.findElementsByTagName("a");
        URL url;
        for (int i = 0; i < elements.size(); i++) {
            String siteUrl = elements.get(i).getAttribute("href");
            url = new URL(siteUrl);
            HttpURLConnection huc = (HttpURLConnection) (url.openConnection());
            huc.setRequestMethod("HEAD");
            huc.connect();
            int respCode = huc.getResponseCode();
            if (respCode >= 400) {
                System.out.println(siteUrl);
            }
        }
    }
}
