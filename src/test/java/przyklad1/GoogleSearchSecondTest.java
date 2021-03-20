package przyklad1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchSecondTest extends TestBase {

    private WebDriver driver;

    @Before
    public void setUp()
    {
        super.configureTest("http://www.google.com");
        driver = super.driver;
    }

    @Test
    public void searchGivenPhrase()
    {
        // Arrange
        String searchPhrase = "Mistrzostwa Europy w piłce nożnej 2012";

        // wyszukanie elementu do wpisywania tekstu
        WebElement element = driver.findElement(By.name("q"));

        // Act
        // czyszczenie elementu, wpisanie tekstu, wyslanie zapytania
        element.clear();
        element.sendKeys(searchPhrase);
        element.submit();

        // Assert
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(searchPhrase));
    }

    @After
    public void tearDown()
    {
        // zamkniecie przegladarki
        driver.quit();
    }
}
