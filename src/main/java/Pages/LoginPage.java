package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name = 'passwd']")
    private WebElement passwEnter;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;

    public LoginPage(){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    public MailPage login(String login, String passwd){
        loginInput.sendKeys(login);
        submitButton.click();
        passwEnter.sendKeys(passwd);
        submitButton.click();
        return new MailPage();
    }
}
