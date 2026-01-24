import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected TopbarPage topbarPage;

    @BeforeMethod
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        homePage = new HomePage(driver);

        topbarPage = homePage.topbarPage();
    }
}
