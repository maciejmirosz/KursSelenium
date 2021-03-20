package przyklad1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchTest {

    private WebDriver driver;

    @Before
    public void setUp() {
//        // Uruchom nowy egzemplarz przeglądarki Firefox
//        System.setProperty("webdriver.gecko.driver",
//                "src/main/resources/drivers/geckodriver.exe");
//        driver = new FirefoxDriver();

        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://www.google.com");
    }
    @Test
    public void testGoogleSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść teskst zapisany w elemencie
        element.clear();

        // Wpisz informacje do wyszukania
        element.sendKeys("Testowanie Selenium WebDriver");

        // Prześlij formularz
        element.submit();
    }

    @Test
    public void typePhrase()
    {
        WebElement field = driver.findElement(By.name("q"));
        field.sendKeys("bank");
        int size = driver.findElements(By.tagName("iframe")).size();
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(0);
        WebElement button = driver.findElement(By.cssSelector("#introAgreeButton > span > span"));
        button.click(); // nie wiem dlaczego metoda click() nie działa?
        field.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}
