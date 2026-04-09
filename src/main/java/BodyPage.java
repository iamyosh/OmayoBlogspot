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
    private By timerEnaleButton = By.id("timerButton");
    private By doubleClickButton = By.xpath("//button[normalize-space()='Double click Here']");
    private By checkThisButton = By.xpath("//button[text()='Check this']");
    private By checkBox = By.id("dte");

    private By password = By.xpath("//input[@name='pswrd']");
    private By username = By.xpath("//input[@name='userid']");
    private By loginButton = By.xpath("//input[@type='button' and @value='Login']");

    private By textareaField = By.xpath("//textarea[@id='ta1' and @rows='10' and @cols='80']");
    private By textareaField2 = By.xpath("//textarea[@rows='10' and @cols='30']");

    private By htmlUsername = By.xpath("//input[@type='text']");
    private By htmlPassword = By.xpath("//input[@type='password']");
    private By htmlLoginButton = By.xpath("//button[@type='button' and @value='LogIn']");

    private By radioBtn2 = By.id("radio2");
    private By alertDemoBtn = By.id("alert1");
    private By promtBtn = By.id("prompt");
    private By confirmationBtn = By.id("confirm");

    private By frame01 = By.id("iframe1");

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
        wait.withTimeout(Duration.ofSeconds(10));

        driver.navigate().back();       //back to previous

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(textLink));     //DisplayForTimeAndDissapear text link
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        driver.switchTo().alert().accept();     //accept alert window


        //opening popup window and closing
        wait.until(ExpectedConditions.elementToBeClickable(popWindow)).click();

        String mainWindow = driver.getWindowHandle();       //store main window handle
        Set<String> allWindows = driver.getWindowHandles(); //get all window handles

        for (String handle : allWindows) {                   //loop through handles (current handle is stored in 'handle')
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);           //switch to popup
                driver.close();                             //close popup
                driver.switchTo().window(mainWindow);       //back to main window
            }
        }

        //upload file
        WebElement uploadElement = wait.until(ExpectedConditions.elementToBeClickable(uploadFile));
        uploadElement.sendKeys("C:\\Users\\MY FILE\\Downloads\\WhatsApp Image 2026-04-01 at 11.15.19 PM.jpeg");  //send file path directly

        //Timer enable button + alert
        wait.until(ExpectedConditions.elementToBeClickable(timerEnaleButton)).click();
        driver.switchTo().alert().accept();


        //double click
        Actions actions = new Actions(driver);
        WebElement element1 = driver.findElement(doubleClickButton);
        actions.doubleClick(element1).perform();
        driver.switchTo().alert().accept();


        //checking button
        wait.until(ExpectedConditions.elementToBeClickable(checkThisButton)).click();
        wait.withTimeout(Duration.ofSeconds(15));
        driver.findElement(checkBox).click();


        //login section
        driver.findElement(username).sendKeys("Yosh");
        driver.findElement(password).sendKeys("123456");
        driver.findElement(loginButton).click();
        driver.switchTo().alert().accept();


        //textarea fields
        wait.until(ExpectedConditions.presenceOfElementLocated(textareaField)).sendKeys("This is a text field");

        WebElement textareaElement = wait.until(ExpectedConditions.presenceOfElementLocated(textareaField2));
        textareaElement.clear();        //remove the text already there
        textareaElement.sendKeys("This is also a text field");


        //html form
        wait.until(ExpectedConditions.presenceOfElementLocated(htmlUsername)).sendKeys("Yosh");
        wait.until(ExpectedConditions.presenceOfElementLocated(htmlPassword)).sendKeys("123");
        driver.findElement(htmlLoginButton).click();


        //radio options
        wait.until(ExpectedConditions.elementToBeClickable(radioBtn2)).click();

        //alert demo - 'Click to get alert'
        wait.until(ExpectedConditions.elementToBeClickable(alertDemoBtn)).click();
        driver.switchTo().alert().accept();

        //get prompt
        wait.until(ExpectedConditions.elementToBeClickable(promtBtn)).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("yosh ro");
        alert.accept();

        //confirmation alert window
        wait.until(ExpectedConditions.elementToBeClickable(confirmationBtn)).click();
        driver.switchTo().alert().accept();

        wait.withTimeout(Duration.ofSeconds(10));

    }

    public void iframeSelection() throws InterruptedException{
        //iframes
        WebElement frame1 = wait.until(ExpectedConditions.visibilityOfElementLocated(frame01));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", frame1);

        driver.switchTo().frame(frame1);  //go to frame 1
        jse.executeScript("window.scroll(0,8000)");

        driver.switchTo().defaultContent();
    }





}
