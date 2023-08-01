package config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    public void setUP(){
        driver=ConfiguretionWebDriver.createDriver(WebDrivers.BONYGARSIA);
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
