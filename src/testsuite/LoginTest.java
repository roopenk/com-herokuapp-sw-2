package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    // Verifying that Upon applying the valid credentials user should be logged in
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Locating the username element and sending the value to it
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Locating the Password element and sending the value to it
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Locating the Login button element and performing the click operation on it
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        // Verifying the "Secure Area" text
        String expectedMessage = "Secure Area";
        // Locating and storing the "Secure Area" message
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        String actualMessage = actualTextElement.getText();
        // Comparing the results
        Assert.assertEquals("Invalid Message..!", expectedMessage, actualMessage);
    }

    @Test
    // Verifying that Upon applying the invalid credentials user should not be logged in
    public void verifyTheUsernameErrorMessage() {
        // Locating the username element and sending the value to it
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Locating the Password element and sending the value to it
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Locating the Login button element and performing the click operation on it
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        String expectedMessage = "Your username is invalid!";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText().substring(0, 25);
        // Comparing the results
        Assert.assertEquals("Invalid Message..!", expectedMessage, actualMessage);
    }

    @Test
    // Verifying that Upon applying the invalid credentials user should not be logged in
    public void verifyThePasswordErrorMessage() {
        // Locating the username element and sending the value to it
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Locating the Password element and sending the value to it
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // Locating the Login button element and performing the click operation on it
        driver.findElement(By.xpath("//i[text()=' Login']")).click();
        String expectedMessage = "Your password is invalid!";
        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualMessage = actualTextElement.getText().substring(0, 25);

        // Comparing the results
        Assert.assertEquals("Invalid Message..!", expectedMessage, actualMessage);
    }

    @After
    public void cutOff() {
        closeBrowser();
    }
}
