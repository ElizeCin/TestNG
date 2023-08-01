import config.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class DZ_20_Certificate extends BaseClass {
    @DataProvider
    public static Object[][] certificateNumber() {
        return new Object[][]{
                {"1234567", notValidMessage},
                {"5678899", notValidMessage},
                {"45924126", downloadButton}
        };
    }

    private By page = By.xpath("//*[@id=\"body\"]/div[1]/div[1]/div[2]/div/div/nav/ul/li[2]/button");
    private By certificate = By.xpath("//*[@id=\"certificateCheckForm\"]/div/input");
    private By button = By.xpath("//*[@id=\"certificateCheckForm\"]/div/button");
    private static By notValidMessage = By.xpath("//*[@id=\"certificateCheckForm\"]/p");
    private static By downloadButton = By.xpath("//*[@id=\"certificatePng\"]");

    @Test
    public void test1() {
        driver.get("https://ithillel.ua/");
        WebElement coursesPage = driver.findElement(page);
        assertTrue(coursesPage.isDisplayed());
    }

    @Test(dependsOnMethods = {"test1"}, dataProvider = "certificateNumber")
    public void test2(String certificateNumber, By by) {
        driver.get("https://certificate.ithillel.ua/");
        driver.findElement(certificate).sendKeys(certificateNumber);
        driver.findElement(button).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));  // waiting to find expected element
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        assertTrue(element.isDisplayed());
    }
}
