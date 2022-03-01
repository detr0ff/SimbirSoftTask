import Browser.WebDriverFactory;
import Pages.MailPage;
import Pages.MainPage;
import Utils.PropertyReader;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class TestYandexMail {
    private static final String propertyFilePath = "src/test/resources/conf.properties";
    private static final String url = PropertyReader.getProperty(propertyFilePath, "url");
    private static final String login = PropertyReader.getProperty(propertyFilePath, "login");
    private static final String password = PropertyReader.getProperty(propertyFilePath, "password");
    private static final String newLetterEmail = PropertyReader.getProperty(propertyFilePath, "newLetterEmail");
    private static final String mailTheme = PropertyReader.getProperty(propertyFilePath, "mailTheme");

    @Before
    public static void start(){
        WebDriver driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void testSendMail(){
        MainPage mainPage = new MainPage();
        mainPage.goLogin()
                .login(login, password);
        MailPage mailPage = new MailPage();
        int mailsCount = mailPage.getCountMailsByTitle(mailTheme);
        int newMailsCount = mailPage.writeNewMail(newLetterEmail, mailTheme, String.format("Найдено %d писем", mailsCount))
                .refreshButtonClick()
                .getCountMailsByTitle(mailTheme);
        Assert.assertEquals(newMailsCount, mailsCount+1);
    }

    @After
    public static void end(){
        WebDriverFactory.getDriver().quit();
    }
}
