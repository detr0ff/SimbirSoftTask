package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//a[contains(@class, 'HeadBanner-Button-Enter')]")
    private WebElement loginButton;

    public MainPage(){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    public LoginPage goLogin(){
        loginButton.click();
        return new LoginPage();
    }
}
