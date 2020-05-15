package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput {

    private static final String LOCATOR = "//article//span[contains(text()" +
            ",'%s')]/../..//input";
    WebElement element;

    public TextInput(WebDriver driver, String label) {
        element = driver.findElement(By.xpath(String.format(LOCATOR, label)));
    }

    public void write(String text) {
        element.sendKeys(text);
    }
}