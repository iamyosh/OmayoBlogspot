import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BodyPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By dropDownList = By.className("combobox");
    private By link1 = By.linkText("Selenium143");
    private By textLink = By.id("alert2");
    private By popWindow = By.linkText("Open a popup window");
    private By uploadFile = By.id("uploadfile");

    public BodyPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //multiselect in list
    public void multiList(){
        List<WebElement> options = driver.findElements(By.xpath("//*[@id='multiselect1']/option"));
        //use 'findElement"s"' bcz its a list not one & 'option' in xpath to select all elements

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).click(options.get(0))
                .click(options.get(1)).keyUp(Keys.CONTROL).perform();
        //ctrl key -> CONTROL to select many. 1 - index of 2nd element & 2 - 3rd element
        //keyDown+CONTROL -> press ctrl
        //keyUp+CONTROL -> release ctrl

    }

    public void selectFromDropdown(){
        //can only use select keyword if html has <select>
        Select select = new Select(driver.findElement(dropDownList));
        select.selectByVisibleText("doc 3");
    }

    public void clickLink() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(link1)).click();     //opening in new window
        wait.withTimeout(Duration.ofSeconds(5));

        driver.navigate().back();       //back to previous

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textLink));     //DisplayForTimeAndDissapear text link
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        driver.switchTo().alert().accept();     //accept alert window


        //opening popup window and closing
        wait.until(ExpectedConditions.elementToBeClickable(popWindow)).click();

        String mainWindow = driver.getWindowHandle();       //store main window handle
        Set<String> allWindows = driver.getWindowHandles(); //get all window handles

        for (String handle : allWindows){                   //loop through handles (current handle is stored in 'handle')
            if (!handle.equals(mainWindow)){
                driver.switchTo().window(handle);           //switch to popup
                driver.close();                             //close popup
                driver.switchTo().window(mainWindow);       //back to main window
            }
        }

        //upload file
        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(uploadFile));
        uploadElement.sendKeys("C:\\Users\\MY FILE\\Downloads\\relational-database.png");  //send file path directly

    }

}
