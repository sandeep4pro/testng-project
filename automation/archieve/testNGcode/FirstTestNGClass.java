package web.automation.testNGcode;

import org.testng.annotations.Test;

public class FirstTestNGClass extends AnnotationsMethod {
    @Test(groups = {"group"})
    public void testMethod1() {
        System.out.println("This is first testNG method - 1");
    }

    @Test(dependsOnMethods = {"testMethod1"}, groups = "group")
    public void testMethod2() {
        System.out.println("This is first testNG method - 2");
    }

    @Test(dependsOnMethods = {"testMethod1", "testMethod2", "testMethod3"}, groups = "group")
    public void testMethod0() {
        System.out.println("This is first testNG method - 0");
    }

    @Test(dependsOnMethods = {"testMethod2"}, groups = {"group"})
    public void testMethod3() {
        System.out.println("This is first testNG method - 3");
    }

    @Test(dependsOnGroups = {"group"})
    public void testMethod00() {
        System.out.println("This is first testNG method - 00");
    }
}
