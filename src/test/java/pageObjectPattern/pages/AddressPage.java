package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

    private WebDriver driver;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "id_country")
    private Select countrySelect;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillNewAddress(
            String address,
            String city,
            String zip,
            String country) {
        addressField.clear();
        addressField.sendKeys(address);
        // podobnie dla pól city, zip code i country

        //countrySelect.sendKeys(country);
        //Select selectDropdown = new Select(countrySelect);
        countrySelect.selectByVisibleText(country);

    }
}
