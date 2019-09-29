package webdriver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.sanchellios.prog.experiments.selenium.Constants.GOOGLE_URL;
import static ru.sanchellios.prog.experiments.selenium.Constants.YANDEX_URL;

@Tag("WebDriver")
public class VariousFeaturesTest extends BaseWebDriverTest {

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

    @Test
    @DisplayName("WebDriver can switch between windows")
    public void switchBetweenWindowsTest() {
        driver.get(YANDEX_URL);

        String searchPageWindowHandle = driver.getWindowHandle();
        WebElement linkToVideoPage = driver.findElement(By.linkText("Видео"));

        Actions actions = new Actions(driver);
        actions.moveToElement(linkToVideoPage).keyDown(Keys.LEFT_SHIFT).click().keyUp(Keys.LEFT_SHIFT).build().perform();

        String videoPageHandle = driver.getWindowHandle();

        driver.switchTo().window(searchPageWindowHandle);
        Assertions.assertEquals(YANDEX_URL, driver.getCurrentUrl());

        driver.switchTo().window(videoPageHandle);
        Assertions.assertTrue(driver.getPageSource().contains("video"));
    }

    @Test
    @DisplayName("WebDriver can switch to alert")
    public void switchToAlertTest() {
        driver.get(YANDEX_URL);
        String message = "HELLO";

        driver.executeScript("alert('" + message + "')");
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assertions.assertEquals(message, alertText);
    }

    @Test
    @DisplayName("WebDriver could navigate through history")
    public void navigateThroughHistoryTest() {

    }

}
