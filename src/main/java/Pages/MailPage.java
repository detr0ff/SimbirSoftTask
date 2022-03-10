package Pages;

import Browser.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailPage {

    @FindBy(className = "mail-MessageSnippet-Content")
    private WebElement mailTable;

    @FindBy(xpath = "//a[contains(@class, 'mail-ComposeButton')]")
    private WebElement newMailButton;

    @FindBy(xpath = "//span[contains(@class, 'mail-ComposeButton-Refresh')]")
    private WebElement refreshButton;

    @FindBy(xpath = "//div[contains(@class, 'js-loading-bar')]")
    WebElement loadBar;

    WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(10));

    public MailPage(){
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    public int getCountMailsByTitle(String title){
        return mailTable.findElements(By.xpath(String.format("//span[@title = '%s']", title))).size();
    }

    public MailPage writeNewMail(String recipient, String theme, String text){
        newMailButton.click();
        NewMailForm newMailForm = new NewMailForm();
        newMailForm.writeMail(recipient, theme, text);
        return this;
    }

    public MailPage refreshButtonClick(){
        refreshButton.click();
        wait.until(ExpectedConditions.attributeContains(loadBar, "style", "width: 0%"));
        return this;
    }
}
