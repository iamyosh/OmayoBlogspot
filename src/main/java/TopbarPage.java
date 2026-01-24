import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TopbarPage {
    private WebDriver driver;
    private By search = By.name("q");


    public TopbarPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchBar(){
        driver.findElement(search).sendKeys("selenium tests" + Keys.ENTER);

    }
}
