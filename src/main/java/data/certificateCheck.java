package data;

import org.testng.annotations.DataProvider;

public class certificateCheck {
    @DataProvider
    public static Object[][] certificateNumber() {
        return new Object[][]{
                {"1234567"},
                {"5678899"},
                {"0978721"}
        };
    }
}
