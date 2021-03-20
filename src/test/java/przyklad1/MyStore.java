package przyklad1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class MyStore {

    WebDriver driver;

    @Given("new web")

    public void newWeb () {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl");
    }
    @When("login to my store")

    public void loginToMyStore() {

        WebElement signInButton = driver.findElement(By.cssSelector("span.hidden-sm-down"));
        signInButton.click();

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.clear();
        emailField.sendKeys("lefaka7503@heroulo.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("1Q2W3E4R");

        WebElement signInButton2 = driver.findElement(By.id("submit-login"));
        signInButton2.click();

    }
    @Then("navigate to create new address view")

    public void navigateToCreateNewAddressView() {
        WebElement myAccountSection = driver.findElement(By.id("my-account"));
        myAccountSection.click();

        WebElement addressesSection = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span/i"));
        addressesSection.click();



        WebElement newAddressSection = driver.findElement(By.xpath("//span[.='Create new address']"));
        newAddressSection.click();
    }

    @And("^fill and add new alias (.*)$")
    public void fillAndAddNewAlias(String alias) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        aliasInput.sendKeys(alias);
    }

    @And("^fill and add new address (.*)$")
    public void fillAndAddNewAddress(String address) {
        WebElement addressInput = driver.findElement(By.name("address1"));
        addressInput.sendKeys(address);
    }

    @And("^fill and add new city (.*)$")
    public void fillAndAddNewCity(String city) {
        WebElement cityInput = driver.findElement(By.name("city"));
        cityInput.sendKeys(city);
    }

    @And("^fill and add new zip (.*)$")
    public void fillAndAddNewZip(String zip) {
        WebElement zipInput = driver.findElement(By.name("postcode"));
        zipInput.sendKeys(zip);
    }


    @And("^fill and add new phone (.*)$")
    public void fillAndAddNewPhone(String phone) {
        WebElement zipInput = driver.findElement(By.name("phone"));
        zipInput.sendKeys(phone);
    }

    @And("^click save$")
    public void clickSave() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn.btn-primary.float-xs-right"));
        saveButton.click();
    }

    @And("wait and check if data in new address is correct")
    public void waitAndCheckIfDataInNewAddressIsCorrect(){
        List<WebElement> addedAddresses = driver.findElements(By.cssSelector("article.address"));
        WebElement lastAddress = addedAddresses.get(addedAddresses.size()-1);
        String lastAddressText = lastAddress.getText();
        assertTrue(lastAddressText.contains("Alias"));
        assertTrue(lastAddressText.contains("Address"));
        assertTrue(lastAddressText.contains("City"));
        assertTrue(lastAddressText.contains("Zip"));
        assertTrue(lastAddressText.contains("500500500"));
        //lastAddress.findElements();

    }

}