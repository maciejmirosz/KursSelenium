package pageObjectPattern;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPattern.pages.AddressPage;
import pageObjectPattern.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginWithProperCredentialsNoPageObject() {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("johnd@mail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.click();
        passwordInput.sendKeys("qwerty");

        driver.findElement(By.id("submit-login")).click();

        // weryfikacja, czy udało się zalogować poprzez pobranie imienia i nazwiska użytkownika
        //WebElement firstAndLastNameLabel = driver.findElement(By.cssSelector("#_desktop_user_info span"));
        //String firstAndLastNameText = firstAndLastNameLabel.getText();
        String firstAndLastNameText = driver.findElement(By.cssSelector("#_desktop_user_info span")).getText();

        // Assert
        String expected = "John Doe";
        Assert.assertEquals(expected, firstAndLastNameText);
    }

    @Test
    public void testLoginWithProperCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");
        Assert.assertEquals("John Doe", loginPage.getLoggedUsername());
    }

    @Test
    public void addNewAddress() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
        AddressPage addressPage = new AddressPage(driver);
        addressPage.fillNewAddress(
                "Sezamkowa 11",
                "Gdańsk",
                "00-001",
                "United Kingdom"
        );
    }
}
