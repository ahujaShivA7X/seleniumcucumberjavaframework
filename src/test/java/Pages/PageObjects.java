package Pages;

import Base.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjects extends Utils {

    Utils ut = new Utils();

    @FindBy(xpath = "//a[@href = 'https://www.katalon.com/sign-in']")
            private WebElement signin;

    @FindBy(id = "user_email")
            private WebElement username;

    @FindBy(id = "user_pass")
            private WebElement password;


    public WebElement clickSignIn(){
        signin.click();
        return  signin;
    }

    public WebElement enterUsername(String user){
        username.sendKeys(user);
        return  username;
    }

    public WebElement enterPassword(String pass){
        password.sendKeys(pass);
        return  password;
    }

}
