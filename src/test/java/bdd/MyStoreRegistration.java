package bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreRegistration {

    WebDriver driver;

    @Given("user is on registration page")
    public void goToRegistrationPage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
    }


    @When("^user inputs (.*), (.*), email, password$")
    public void userInputsFirstNameLastNameEmailPassword(String firstName, String lastName) {
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys(lastName);
    }
}
