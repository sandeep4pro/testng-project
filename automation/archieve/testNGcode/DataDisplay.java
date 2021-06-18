package web.automation.testNGcode;

import org.testng.annotations.Test;

public class DataDisplay {
    @Test(dataProvider = "testData", dataProviderClass = Data.class)
    public void display(int a, int b, int c) {
        System.out.println(a + b + c);
    }

    @Test(dataProvider = "testData1", dataProviderClass = Data.class)
    public void display1(String fn, String ln) {
        System.out.println(fn + " " + ln);
    }
}
