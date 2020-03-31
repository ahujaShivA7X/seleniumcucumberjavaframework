package Base;

import com.aventstack.extentreports.ExtentReports;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utils {

        public static WebDriver driver = null;
        public static Properties OR = null;
        public static Properties config = null;
        public static FileInputStream fis = null;
        public static String reportLocation = "C:\\Users\\ahuja\\reports";
        public ExtentReports extent;

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //default constructor
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
        public void openBrowser(String browser) {
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
        public void navigate(String url) {

            driver.get(url);
            try{
                Assert.assertEquals(url, driver.getCurrentUrl());
                System.out.println("Navigated to correct webpage");
            }
            catch(Throwable pageNavigationError){
                System.out.println("Didn't navigate to correct webpage");
            }
        }

        // click on any object
        public void click(String object) {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object)))).click();
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

        public void wait(String object) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element;
            element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
        }

        public void scrollDown() {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,250)", "");
        }
}
