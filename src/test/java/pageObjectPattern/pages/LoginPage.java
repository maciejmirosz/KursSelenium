package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    private WebDriver driver;

    @FindBy(name="email")
    private WebElement loginInput;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(id="submit-login")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
//        loginInput.click();
//        loginInput.clear();
//        loginInput.sendKeys(email);
        super.sendKeys(loginInput, email);

//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);

        super.sendKeys(passwordInput, password);

        signInButton.click();
    }

    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }
}

