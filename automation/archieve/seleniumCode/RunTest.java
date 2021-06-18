package web.automation.seleniumCode;

import io.cucumber.junit.CucumberOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
@Test
@Parameters("browser")
public class RunTest {
    private void testMethod(String browser) {
        System.out.println(browser);
    }
}
