package web.automation.utilities;


import org.testng.annotations.*;

import java.util.Objects;

public class Hooks extends BrowserConfiguration {

    @BeforeMethod
    @Parameters({"browser"})
    protected void openApp(@Optional("chrome") String browser) {
        BrowserConfiguration.openBrowser(browser);
        Objects.requireNonNull(getDriver()).navigate().to(ConfigReader.getData("appUrl"));
    }

    @AfterMethod
    protected void closeDriver() {
        Objects.requireNonNull(getDriver()).quit();
    }
}
