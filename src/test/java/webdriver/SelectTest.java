package webdriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectTest extends BaseWebDriverTest {

    @Test
    @DisplayName("WebDriver gets text from value attribute of select-options")
    public void getTextFromSelectOptionTest() {
        String starOceansSite = "http://www.staroceans.org/w3c/howto_custom_select.asp.html";
        driver.get(starOceansSite);
        WebElement select = driver.findElement(By.cssSelector("select:first-child"));
        List<WebElement> options = select.findElements(By.tagName("option"));

        for(WebElement e : options) {
            String name = e.getAttribute("innerText");
            System.out.println("The name of option is '" + name + "' ");
            Assertions.assertNotEquals("", name);
        }

    }

    @Test
    @DisplayName("WebDriver selects by visible text")
    public void selectByVisibleTextTest() {
        driver.get("https://mdbootstrap.com/docs/jquery/forms/select/");
        WebElement selectWebElement = driver.findElement(By.cssSelector("section.p-1 select.browser-default.custom-select"));
        Select select = new Select(selectWebElement);

        select.selectByIndex(1);
        Assertions.assertEquals("One", select.getAllSelectedOptions().get(0).getText());
    }
}
