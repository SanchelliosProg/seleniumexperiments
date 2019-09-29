package webdriver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sanchellios.prog.experiments.selenium.Constants.GOOGLE_URL;
import static ru.sanchellios.prog.experiments.selenium.Constants.YANDEX_URL;

@Tag("WebDriver")
public class VariousFeaturesTest extends BaseWebDriverTest{

    @Test
    @DisplayName("Fetching a Page")
    public void fetchPageTest() {
        driver.get(GOOGLE_URL);
        String titleText = driver.findElement(By.cssSelector("head title")).getAttribute("textContent");
        assertEquals("Google", titleText);
    }

    @Test
    @DisplayName("Getting text values")
    public void getTextValuesTest() {
        driver.get(YANDEX_URL);
        WebElement element = driver.findElement(By.cssSelector("a.home-link.b-sethome"));
        assertEquals("Сделать стартовой", element.getText());
    }

}
