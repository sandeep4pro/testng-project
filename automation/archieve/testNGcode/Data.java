package web.automation.testNGcode;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "testData")
    public Object[][] dataMethod() {
        return new Object[][]{{1, 2, 3}, {4, 5, 6}};
    }

    @DataProvider(name = "testData1")
    public Object[][] dataMethod1() {
        return new Object[][]{{"Sandeep", "Kumar"}, {"Aahan", "Keshri"}};
    }
}
