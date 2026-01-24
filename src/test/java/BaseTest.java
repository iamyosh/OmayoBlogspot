import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setDriver()throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://omayo.blogspot.com/");

        homePage = new HomePage(driver);
        homePage.searchBar();
    }
}
