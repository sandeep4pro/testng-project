package web.automation.testNGcode;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {
    @Test
    @Parameters({"firstName", "lastName"})
    public void testMethod1(String fn, String ln) {
        System.out.println("My name is " + fn + " " + ln);
    }

    @Test
    @Parameters({"num1", "num2"})
    public void testMethod2(int num1, int num2) {
        System.out.println("Multiplication of two numbers is " + (num1 * num2));
    }

    @Test
    @Parameters({"firstName1"})
    public void testMethod3(@Optional("Sandeep") String fn) {
        System.out.println("My name is " + fn);
    }

}
