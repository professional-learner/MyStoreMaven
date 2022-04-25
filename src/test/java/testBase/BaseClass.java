package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ExcelReader;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public ExcelReader excel = null;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();

    }

}
