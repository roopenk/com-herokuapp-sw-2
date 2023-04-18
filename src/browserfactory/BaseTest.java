package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) { // Universal method to open any URL just by calling this method
        driver = new ChromeDriver();
        // Launching The URL
        driver.get(baseUrl);
        // Maximizing the browser window
        driver.manage().window().maximize();
        // Applying the implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}