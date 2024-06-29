package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='country-current']")
    WebElement countryDropdown;

    @FindBy(xpath = "//a[@id='kw']")
    WebElement kuwaitOption;

    @FindBy(xpath = "//a[@id='bh']")
    WebElement bahrainOption;

    @FindBy(xpath = "//a[@id='sa']")
    WebElement saudiOption;

    @FindBy(id = "name-lite")
    WebElement litePackageName;

    @FindBy(id = "name-classic")
    WebElement classicPackageName;

    @FindBy(id = "name-premium")
    WebElement premiumPackageName;

    @FindBy(xpath = "//div[@id='currency-lite']/b")
    WebElement litePackagePrice;

    @FindBy(xpath = "//div[@id='currency-lite']/i")
    WebElement liteCurrency;

    @FindBy(xpath = "//div[@id='currency-classic']/b")
    WebElement classicPackagePrice;

    @FindBy(xpath = "//div[@id='currency-classic']/i")
    WebElement classicCurrency;

    @FindBy(xpath = "//div[@id='currency-premium']/b")
    WebElement premiumPackagePrice;

    @FindBy(xpath = "//div[@id='currency-premium']/i")
    WebElement premiumCurrency;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String country) {
        countryDropdown.click();
        switch (country) {
            case "Saudi Arabia":
                saudiOption.click();
                break;
            case "Kuwait":
                kuwaitOption.click();
                break;
            case "Bahrain":
                bahrainOption.click();
                break;
        }
    }

    public String getLitePackageName() {
        return litePackageName.getText();
    }

    public String getClassicPackageName() {
        return classicPackageName.getText();
    }

    public String getPremiumPackageName() {
        return premiumPackageName.getText();
    }

    public String getLitePackagePrice() {
        return litePackagePrice.getText();
    }

    public String getLiteCurrency() {
        return liteCurrency.getText().replace("/month", "").trim();
    }

    public String getClassicPackagePrice() {
        return classicPackagePrice.getText();
    }

    public String getClassicCurrency() {
        return classicCurrency.getText().replace("/month", "").trim();
    }

    public String getPremiumPackagePrice() {
        return premiumPackagePrice.getText();
    }

    public String getPremiumCurrency() {
        return premiumCurrency.getText().replace("/month", "").trim();
    }
}
