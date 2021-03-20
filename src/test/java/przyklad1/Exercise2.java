package przyklad1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class Exercise2 {
    WebDriver driver;

    @Given("an open browser with my store")

    public void goToMyStore () {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl");
    }
    @When("log in to my store")

    public void logInToMyStore() {

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

    @Then("^navigate to clothes page$")
    public void navigateToClothesPage() {
        WebElement mainPage = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        mainPage.click();
    }

    @And("^navigate to Hummingbird Printed Sweater$")
    public void navigateToHummingbirdPrintedSweater() {

        WebElement sweater = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[2]/div/a/img"));
        sweater.click();
    }

    @And("^choose size$")
    public void chooseSize() {
        WebElement sizePicklist = driver.findElement(By.id("group_1"));
        sizePicklist.click();

        WebElement size = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        size.click();
    }

    @And("^choose quantity$")
    public void chooseQuantity() {
        WebElement quantity = driver.findElement(By.name("qty"));
        quantity.click();
        quantity.clear();
        quantity.sendKeys("5");
    }

    @And("^add product to cart$")
    public void addProductToCart() {
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCart.click();
    }

    @And("^go to checkout$")
    public void goToCheckout() {
        WebElement goToCheckout = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a"));
        goToCheckout.click();

        WebElement goToCheckout2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        goToCheckout2.click();

    }

    @And("^confirm address$")
    public void confirmAddress() {
        WebElement confirmAddress = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        confirmAddress.click();

    }

    @And("^choose delivery method$")
    public void chooseDeliveryMethod() {
        WebElement deliveryMethod = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        deliveryMethod.click();

    }

    @And("^choose payment option$")
    public void choosePaymentOption() {
        WebElement paymentOption = driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]"));
        paymentOption.click();

    }

    @And("^make an order$")
    public void makeAnOrder() {

        WebElement agreement = driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        agreement.click();

        WebElement paymentConfirmation = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        paymentConfirmation.click();

    }

    @And("^take screenshot$")
    public void takeScreenshot() throws Exception {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
        FileUtils.copyFile(scrFile, new File("/home/maciej/Obrazy/screenshot.png"));
    }
}