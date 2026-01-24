import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopbarPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By search = By.name("q");
    private By selectMore = By.className("select.L3Qlm");

    public TopbarPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void searchBar(){
        driver.findElement(search).sendKeys("selenium tests" + Keys.ENTER);
    }

    public void backToHome(){
        WebElement showAllPostsLink = driver.findElement(By.linkText("Show all posts"));
        showAllPostsLink.click();
    }

    public void moreOption(){
       WebElement moreDropdown = driver.findElement(selectMore);
       moreDropdown.click();

    }
}