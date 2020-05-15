package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextInput {
    private static final String LOCATOR = "//article//span[contains(text()" +
            ",'%s')]/../..//input";
    WebElement element;

    public TextInput(WebDriver driver, String label) {
        System.out.println("looking for element with label: " + label);
        element = driver.findElement(By.xpath(String.format(LOCATOR, label)));
    }

    public void write(String text) {
        if(null!=text) {
            System.out.println("writing text into input: " + text);
            element.sendKeys(text);
        } else {
            element.clear();
        }
    }
}