package StepDef;

import Base.Utils;
import Pages.PageObjects;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepdefs extends Utils {

    Utils base = new Utils();

    PageObjects pom = new PageObjects();


    @Given("^Go to the website \"([^\"]*)\"$")
    public void go_to_the_website_something(String strArg1) throws Throwable {
        openBrowser("Chrome");
        navigate(strArg1);
    }

    @And("^Click on the button \"([^\"]*)\"$")
    public void click_on_the_button_something(String strArg1) throws Throwable {
        pom.clickSignIn();

    }

    @Then("^validate the message \"([^\"]*)\"$")
    public void validate_the_message_something(String strArg1) throws Throwable {
        //driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();

    }

    @And("^enter email id as \"([^\"]*)\"$")
    public void enter_email_id_as_something(String strArg1) throws Throwable {
        pom.enterUsername(strArg1);

    }

    @And("^enter the password as \"([^\"]*)\"$")
    public void enter_the_password_as_something(String strArg1) throws Throwable {
       // driver.findElement(By.id("user_pass")).sendKeys(strArg1);
        pom.enterPassword(strArg1);

    }

    @And("^Uncheck the option \"([^\"]*)\"$")
    public void uncheck_the_option_something(String strArg1) throws Throwable {

    }




}
