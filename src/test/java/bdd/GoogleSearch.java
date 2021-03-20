package bdd;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch()
    {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://www.google.com");
    }

    @When("a keyword (.*) is entered in input field")
    public void enterKeyword(String keyword) {
        WebElement textInputSearch = driver.findElement(By.name("q"));
        textInputSearch.clear();
        textInputSearch.sendKeys(keyword);
        textInputSearch.submit();
    }

    @Then("^the first one should contain (.*)$")
    public void theFirstOneShouldContainSelenium(String expectedText) {
        System.out.println(expectedText);
    }

    @And("^close browser$")
    public void closeBrowser() {
        driver.quit();
    }
}
