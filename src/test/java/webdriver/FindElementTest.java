package webdriver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.sanchellios.prog.experiments.selenium.Constants.*;

@Tag("WebDriver")
public class FindElementTest extends BaseWebDriverTest {

    @Test
    @DisplayName("WebDriver finds element by id")
    public void findElementByIdTest() {
        driver.get(YANDEX_URL);
        WebElement webElement = driver.findElement(By.id(SEARCH_PAGE_NEWS_PANEL_ID));
        assertTrue(webElement.isDisplayed());
    }

    @Test
    @DisplayName("WebDriver finds element by class name")
    public void findElementByClassNameTest() {
        driver.get(YANDEX_URL);
        WebElement webElement = driver.findElement(By.className("news__tabs"));
        assertTrue(webElement.isDisplayed());
    }

    @Test
    @DisplayName("WebDriver finds element by tag name")
    public void findElementByTagNameTest() {
        driver.get(GITHUB_URL);
        WebElement webElement = driver.findElement(By.tagName("head"));
        assertTrue(!webElement.isDisplayed());
        assertTrue(webElement.isEnabled());
    }

    @Test
    @DisplayName("WebDriver finds element by name attribute")
    public void findElementByNameTest() {
        driver.get(YANDEX_URL);
        WebElement webElement = driver.findElement(By.name("lr"));
        assertTrue(!webElement.isDisplayed());
        assertTrue(webElement.isEnabled());
    }

    @Test
    @DisplayName("WebDriver finds element by link text")
    public void findElementByLinkTextTest() {
        driver.get(YANDEX_URL);
        WebElement link = driver.findElement(By.linkText("Видео"));
        link.click();
        assertTrue(driver.getPageSource().contains("portal/video"));
    }

    @Test
    @DisplayName("Web driver finds element by partial link text")
    public void findElementByPartialLinkTextTest() {
        driver.get(YANDEX_URL);
        WebElement link = driver.findElement(By.partialLinkText("Сейчас"));
        link.click();
        assertTrue(driver.getPageSource().contains("/news"));
    }

    @Test
    @DisplayName("Web driver finds element by CSS selector")
    public void findElementByCssSelectorTest() {
        driver.get(YANDEX_URL);
        WebElement linkToMap = driver.findElement(By.cssSelector("a[data-statlog=\"maps.title.regular\"]"));
        linkToMap.click();
        assertTrue(driver.getPageSource().contains("/maps"));
    }

    @Test
    @DisplayName("Web driver finds element by XPATH")
    public void findElementByXpathTest() {
        driver.get(GITHUB_URL);
        WebElement signUpButton = driver.findElement(By.xpath("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']"));
        assertTrue(signUpButton.isDisplayed());
    }

    @Test
    @DisplayName("Web drive could be found by JavaScript Executor")
    public void findElementByJavaScriptExecutorTest() {
        driver.get(YANDEX_URL);
        WebElement element = (WebElement)((JavascriptExecutor) driver)
                .executeScript("return document.querySelector('a#news_tab_news')");
        element.click();
        assertTrue(driver.getPageSource().contains("/news"));
    }
}
