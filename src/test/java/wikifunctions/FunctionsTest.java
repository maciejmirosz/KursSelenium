package wikifunctions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionsTest {

    private WebDriver driver;

    @Before
    public void setUp()
    {
        // wlaczenie przegladarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // maksymalizacja przegladrki
        driver.manage().window().maximize();
    }

    @Test
    public void getText()
    {
        driver.get("https://pl.wikipedia.org/");
        WebElement element = driver.findElement(By.id("main-page-column1"));
        System.out.println(element.getText());
    }

    @Test
    public void getAttribute()
    {
        driver.get("https://pl.wikipedia.org/");
        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
        System.out.println(atrybut);

        // bardzo czesto przydatny jest getAttribute("value")
    }

    @Test
    public void getTagName()
    {
        driver.get("https://pl.wikipedia.org/");
        String tag = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(tag);
    }

    @Test
    public void isEnabled()
    {
        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
        if(search.isEnabled()) {
            search.sendKeys("Selenium");
            search.submit();
        } else {
            Assert.fail();
        }
    }

    @Test
    public void isDisplayed()
    {
        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput"));
        if(search.isDisplayed()) {
            search.sendKeys("Selenium");
            search.submit();
        }else {
            Assert.fail();
        }
    }

    @After
    public void tearDown()
    {
        //driver.quit();
    }
}
