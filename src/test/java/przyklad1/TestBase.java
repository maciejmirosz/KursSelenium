package przyklad1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

    protected WebDriver driver;

    public void configureTest() {
        // wlaczenie przegladarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // maksymalizacja przegladrki
        driver.manage().window().maximize();

        // wejscie na strone bing
        driver.get("https://www.bing.com/");
    }

    public void configureTest(String website) {
        // wlaczenie przegladarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // maksymalizacja przegladrki
        driver.manage().window().maximize();

        // wejscie na strone bing
        driver.get(website);
    }

    public void finishTest() {
        driver.quit();
    }
}
