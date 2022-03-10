package Browser;

import Utils.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverFactory {

    private static WebDriver instance;
    private static final String configFilePath = "src/main/resources/config.properties";
    private static final String browserName = PropertyReader.getProperty(configFilePath, "browser");
    private static final int implicitlyWait = Integer.parseInt(PropertyReader.getProperty(configFilePath, "implicitlyWait"));

    public static WebDriver getDriver(){
        if (instance == null) {
            if (browserName.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                instance = new ChromeDriver();
            }
            if (browserName.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                instance = new FirefoxDriver();
            }
            assert instance != null;
            instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        }
        return instance;
    }
}


