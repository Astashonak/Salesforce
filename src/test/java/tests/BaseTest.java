package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountsPage;
import pages.ContactsPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    LoginPage loginPage;
    AccountsPage accountsPage;
    ContactsPage contactsPage;
    private WebDriver driver;

    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
        contactsPage = new ContactsPage(driver);
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}

