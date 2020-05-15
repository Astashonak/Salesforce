package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextArea {

    private static final String LOCATOR = "//article//span[contains(text()" +
            ",'%s')]/../..//textarea";
    WebElement element;

    public TextArea(WebDriver driver, String label) {
        System.out.println("looking for element with label: " + label);
        element = driver.findElement(By.xpath(String.format(LOCATOR, label)));
    }

    public void write(String text) {
        if(null!=text) {
        System.out.println("writing text into textArea: " + text);
        element.sendKeys(text);
    } else {
        element.clear();
    }
    }
}
