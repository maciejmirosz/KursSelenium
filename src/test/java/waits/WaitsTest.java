package waits;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitsTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void noWaitAtAll() {
        driver.findElement(By.cssSelector("#button1 > p")).click();
    }

    // po prostu czekamy 5 sekund
    // marnujemy czas jesli wyswietlenie elementu nastepuje wczesniej
    // jesli jakis element bedzie wczytywal sie dluzej
    // to wtedy bedzie
    @Test
    public void sleep() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#button1 > p")).click();
    }

    @Test
    public void implicitlyWait() {
        //!!! robimy tylko jeden raz na całego drivera
        // najczesciej w metodzie setUp (@Before)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#button1 > p")).click();
    }

    // w odroznieniu od poprzedniego
    // tutaj stosujemy go per element a nie na calosc
    @Test
    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = driver.findElement(By.cssSelector("#button1 > p"));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#button1 > p"))).click();
    }
}
