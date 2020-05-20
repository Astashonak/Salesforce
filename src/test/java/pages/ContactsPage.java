package pages;

import elements.TextInput;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContactsPage extends BasePage {
    private static final String NEW_BUTTON_CSS = "[title=New]";
    private static final String SAVE_BUTTON_CSS = "[title=Save]";
    private static final String URL = "https://ap17.lightning.force.com/lightning/o/Contact/list?filterName=Recent";
    private static final By ERROR_MESSAGE_LOCATOR = By.cssSelector(".genericError");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ContactsPage isPageOpened() {
        return this;
    }

    @Override
    public ContactsPage openPage() {
        driver.get(URL);
        isPageOpened();
        return this;
    }

    public ContactsPage clickNew() {
        driver.findElement(By.cssSelector(NEW_BUTTON_CSS)).click();
        return this;
    }

    public ContactsPage createContact(Contact contact) {
        new TextInput(driver, "First Name").write(contact.getFirstName());
        new TextInput(driver, "Last Name").write(contact.getLastName());
        new TextInput(driver, "Email").write(contact.getEmail());
        new TextInput(driver, "Department").write(contact.getDepartment());
        driver.findElement(By.cssSelector(SAVE_BUTTON_CSS)).click();
        return this;
    }

    public ContactsPage verifyErrorMessage(String expectedMessage){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ERROR_MESSAGE_LOCATOR));
        String actualMessage = driver.findElement(ERROR_MESSAGE_LOCATOR).getText();
        System.out.println("Actual message: " + actualMessage);
        System.out.println("Expected message: " + expectedMessage);
        Assert.assertEquals(actualMessage, expectedMessage,"no such message");
        return new ContactsPage(driver);
    }
}
