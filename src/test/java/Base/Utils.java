package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.utils.FileUtil;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver driver = null;
    public static Properties OR = null;
    public static Properties config = null;
    public static FileInputStream fis = null;
    public static String reportLocation = "C:\\Users\\ahuja\\reports";
    public ExtentReports extent;

    WebDriverWait wait = new WebDriverWait(driver, 10);
    Actions act = new Actions(driver);


    public Utils() {

        // initialize properties
        System.out.println("***************Initializing Properties file*******************");
        if (OR == null) {
            OR = new Properties();
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            OR.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        {
            config = new Properties();
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Choose the browser where you want to test
    public static void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("Mozilla"))
            driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // navigate to any URL
    public static void navigate(String url) {

        driver.get(url);
        try {
            Assert.assertEquals(url, driver.getCurrentUrl());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }

    // click on any object
    public void click(String object) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object)))).click();
    }

    public void selectFromDropDown(String object, String value){
        Select dropdown = new Select(driver.findElement(By.xpath(OR.getProperty(object))));
        dropdown.selectByValue(value);
    }

    // writing in a text field / select value from a list
    public void input(String object, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object)))).sendKeys(data);
    }

    // checking the presence of a particular element
    public boolean isElementPresent(String object) {
        int count = driver.findElements(By.xpath(OR.getProperty(object))).size();
        if (count == 0)
            return false;
        else
            return true;
    }

    public void clickWhenReady(String object){
        WebElement element = null;
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(object)))).click();
    }

   /* public WebElement wait(String object) {
        WebElement element = null;
        element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
        return element;
    }*/

    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    public void typeInCaps(String object, String text){
        act.moveToElement(driver.findElement(By.xpath(OR.getProperty(object)))).click().keyDown(Keys.SHIFT).sendKeys(text).build().perform();
    }

    public void switchToAnotherTab(){
        Set<String> id = driver.getWindowHandles();
        Iterator<String> it = id.iterator();
        while(it.hasNext()){
        driver.switchTo().window(it.next());}
    }

    public void multipleElementsClickUsingText(String object, String text){
        List<WebElement> ele = driver.findElements(By.xpath(OR.getProperty(object)));
        for(int i=0; i<=ele.size(); i++){
            String eleName = ele.get(i).getText();
            if(eleName.contains(text)){
                driver.findElement(By.xpath(OR.getProperty(object))).click();
            }
        }
    }
}
