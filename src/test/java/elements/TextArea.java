package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {

    private static final String LOCATOR = "//article//span[contains(text()" +
            ",'%s')]/../..//textarea";
    WebElement element;

    public TextArea(WebDriver driver, String label) {
        element = driver.findElement(By.xpath(String.format(LOCATOR, label)));
    }

    public void write(String text) {
        element.sendKeys(text);
    }
}
