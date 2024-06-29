package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SubscriptionPage;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.SubscriptionData;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class SubscriptionTest {
    WebDriver driver;
    SubscriptionPage subscriptionPage;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUp() {
        extent = ExtentManager.getInstance();
        test = extent.createTest("Subscription Test");

        driver = DriverFactory.getDriver();
        driver.get("https://subscribe.stctv.com/sa-en");
        subscriptionPage = new SubscriptionPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }

    @Test
    public void validateSubscriptionPackages() {
        test.info("Starting validateSubscriptionPackages test");

        SubscriptionData[] saData = {
                new SubscriptionData("LITE", "15", "SAR"),
                new SubscriptionData("CLASSIC", "25", "SAR"),
                new SubscriptionData("PREMIUM", "60", "SAR")
        };
        SubscriptionData[] kwData = {
                new SubscriptionData("LITE", "1.2", "KWD"),
                new SubscriptionData("CLASSIC", "2.5", "KWD"),
                new SubscriptionData("PREMIUM", "4.8", "KWD")
        };
        SubscriptionData[] bhData = {
                new SubscriptionData("LITE", "2", "BHD"),
                new SubscriptionData("CLASSIC", "3", "BHD"),
                new SubscriptionData("PREMIUM", "6", "BHD")
        };

        String[] countries = {"Saudi Arabia", "Kuwait", "Bahrain"};
        SubscriptionData[][] allData = {saData, kwData, bhData};

        for (int i = 0; i < countries.length; i++) {
            subscriptionPage.selectCountry(countries[i]);
            test.info("Selected country: " + countries[i]);

            SubscriptionData[] currentData = allData[i];
            try {
                Assert.assertEquals(subscriptionPage.getLitePackageName(), currentData[0].getPackageName());
                Assert.assertEquals(subscriptionPage.getLitePackagePrice(), currentData[0].getPrice());
                Assert.assertEquals(subscriptionPage.getLiteCurrency(), currentData[0].getCurrency());

                Assert.assertEquals(subscriptionPage.getClassicPackageName(), currentData[1].getPackageName());
                Assert.assertEquals(subscriptionPage.getClassicPackagePrice(), currentData[1].getPrice());
                Assert.assertEquals(subscriptionPage.getClassicCurrency(), currentData[1].getCurrency());

                Assert.assertEquals(subscriptionPage.getPremiumPackageName(), currentData[2].getPackageName());
                Assert.assertEquals(subscriptionPage.getPremiumPackagePrice(), currentData[2].getPrice());
                Assert.assertEquals(subscriptionPage.getPremiumCurrency(), currentData[2].getCurrency());
                test.pass("Validation passed for country: " + countries[i]);
            } catch (AssertionError e) {
                test.fail("Validation failed for country: " + countries[i]);
                throw e;
            }
        }
    }
}
