import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopbarPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By search = By.name("q");
    private By blogsOption1 = By.linkText("SeleniumByArun");

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

        Actions actions = new Actions(driver);              //action class to hover over element
        WebElement blogsSelection = driver.findElement(By.id("blogsmenu"));
        actions.moveToElement(blogsSelection).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(blogsOption1));
    }

    public BodyPage goToBodyPage(){
        return new BodyPage(driver);
    }


}