import config.BaseClass;
import org.testng.annotations.*;

public class TestA {
    @BeforeClass
    public void befClass() {
        System.out.println("before class");
    }

    @BeforeMethod
    public void bM() {
        System.out.println("befor method");
    }

    @Test(priority = 10)
    public void test1() throws Exception {
        System.out.println("test1");
        throw new Exception("hi");
    }

    @Test(description = "download", groups = {"smoke", "regretions"}, priority = 1)
    public void test2() {
        System.out.println("test2");
    }

    @Test(dependsOnMethods = {"test1"}, alwaysRun = true)
    public void test3() {
        System.out.println("test3");
    }

    @AfterMethod
    public void aM() {
        System.out.println("after method");
    }
}