package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage isPageOpened() {

        return this;
    }

    @Override
    public LoginPage openPage() {
        driver.get("https://login.salesforce.com/");
        isPageOpened();
        return this;
    }

    public LoginPage provideCredsAndLogin(String usernsme, String password){
        driver.findElement(By.id("username")).sendKeys(usernsme);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("Login")).click();
        return this;
    }

    public AccountsPage verifyLogin(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("trial-subscribe-now")));
        return new AccountsPage(driver);
    }
}