package zadanie2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class KatalonTest {
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

        // wejscie na strone z formularzem
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void fillFormTest()
    {
        String firstName = "Karol";
        String gender = "Female";

        WebElement firstNameLabel = driver.findElement(By.cssSelector("[for='first-name']"));
        WebElement firstNameTextInput = driver.findElement(By.id("first-name"));
        if (firstNameTextInput.isEnabled()) {
            firstNameTextInput.sendKeys(firstName);
            System.out.println(
                    firstNameLabel.getText() +
                    " : " +
                    firstNameTextInput.getAttribute("value"));
        }
        else {
            Assert.fail();
        }

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        if (dateOfBirth.isEnabled()) {
            dateOfBirth.sendKeys("10/10/2010");
            // ewentualnie escape zeby zamknac okienko z wyborem daty
            dateOfBirth.sendKeys(Keys.ESCAPE);
        }
        else {
            Assert.fail();
        }

        // mozna tez znalezc za pomoca tekstu //*[text()='Male']/input
        // ale wtedy problem przy zmianie jezyka
        WebElement genderRadioButton;
        if (gender == "Male")
        {
            genderRadioButton = driver.findElement(
                    By.cssSelector(
                            "#infoForm > div:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]"));
            genderRadioButton.click();
        }
        else if (gender == "Female")
        {
            genderRadioButton = driver.findElement(
                    By.xpath(
                            "//*[@id=\"infoForm\"]/div[3]/div/div/label[2]/input"));
            genderRadioButton.click();
        }

        // klikniecie w Submit
        driver.findElement(By.id("submit")).click();

        // sprawdzenie, czy walidacja dla last name się wyświetlila
        WebElement lastNameValidation = driver.findElement(By.id("last-name-error"));
        Boolean isDisplayed = lastNameValidation.isDisplayed();
        Assert.assertTrue("last-name-error jest niewidoczny", lastNameValidation.isDisplayed());
        Assert.assertEquals("This field is required.", lastNameValidation.getText());
    }

    @Test
    public void funkcja(){
        String[] products = {"t-shirt","mug","notebook","poster","graphic", "cushion" };
        Random random = new Random();
        int randomInteger = random.nextInt(50);
        int wynik_dzielenia;
        wynik_dzielenia = randomInteger % products.length;

        driver.get("https://prod-kurs.coderslab.pl");

        WebElement element = driver.findElement(By.name("s"));
        element.clear();
        element.sendKeys(products[wynik_dzielenia]);
    }

    @After
    public void tearDown()
    {
        // zamkniecie przegladarki
        //driver.quit();
    }
}
