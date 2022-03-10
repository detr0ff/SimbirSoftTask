package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMailForm {

    @FindBy(xpath = "//div[@class = 'compose-LabelRow-Content']/div/div")
    private WebElement whoInput;

    @FindBy(xpath = "//input[contains(@class,  'ComposeSubject-TextField')]")
    private WebElement themeInput;

    @FindBy(xpath = "//div[@role = 'textbox']")
    private  WebElement textBox;

    @FindBy(xpath = "//div[contains(@class, 'ComposeSendButton')]/button")
    private  WebElement sendButton;

    @FindBy(xpath = "//a[contains(@class, 'ComposeDoneScreen-Link')]")
    private  WebElement returnButton;

    @FindBy(xpath = "//div[contains(@class,  'ComposeSubject')]//label")
    private WebElement themeLabel;

    public NewMailForm() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    public void enterRecipient(String name){
        whoInput.sendKeys(name);
        whoInput.click();
    }

    public void enterTheme(String theme){
        themeLabel.click();
        themeInput.sendKeys(theme);
    }

    public void enterText(String text){
        textBox.sendKeys(text);
    }

    public void sendButtonClick(){
        sendButton.click();
    }

    private void returnButtonClick(){
        returnButton.click();
    }

    public void writeMail(String recipient, String theme, String text){
        enterRecipient(recipient);
        enterTheme(theme);
        enterText(text);
        sendButtonClick();
        returnButtonClick();
    }
}
