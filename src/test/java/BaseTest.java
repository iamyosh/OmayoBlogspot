import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected TopbarPage topbarPage;

    @BeforeClass
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");
        homePage = new HomePage(driver);        //initialize homepage

        topbarPage = homePage.topbarPage();
    }
}
