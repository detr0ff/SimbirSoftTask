import Browser.WebDriverFactory;
import Pages.LoginPage;
import Pages.MailPage;
import Pages.MainPage;
import Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testTask {
    String propertyFilePath = "src/test/resources/conf.properties";
    String url = PropertyReader.getProperty(propertyFilePath, "url");
    String login = PropertyReader.getProperty(propertyFilePath, "login");
    String password = PropertyReader.getProperty(propertyFilePath, "password");

    @BeforeMethod
    public void start(){
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void test1(){
        MainPage mainPage = new MainPage();
        mainPage.goLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
        MailPage mailPage = new MailPage();
        int mailsCount = mailPage.getCountMailsByTitle(testData.mailTheme);
        mailPage.writeNewMail(testData.newLetterEmail, testData.mailTheme, String.format("Найдено %d писем", mailsCount));
        mailPage.refreshButtonClick();
        int newMailsCount = mailPage.getCountMailsByTitle(testData.mailTheme);
        Assert.assertEquals(newMailsCount, mailsCount+1);
    }

    @AfterTest
    public void end(){
        WebDriverFactory.getDriver().quit();
    }
}
