package ru.sanchellios.prog.experiments.selenium.yandex;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YandexSearchPageTest {
    private static WebDriver driver = new ChromeDriver();
    private YandexSearchPage yandexSearchPage = new YandexSearchPage(driver);
    private String username = System.getProperty("yandexUsername");
    private String password = System.getProperty("yandexPassword");

    @BeforeEach
    public void loadPage() {
        yandexSearchPage.navigate();
    }

    @Test
    @DisplayName("Search returns 16 results")
    public void searchResultTest() {
        List<WebElement> searchResult = yandexSearchPage.searchFor("hip-hop");
        assertEquals(16, searchResult.size());
    }

    @Test
    @DisplayName("News list contains 4 static news")
    public void staticNews4Test() {}

    @Test
    @DisplayName("News list contains inner list with 6 news")
    public void dynamicNewsTest() {}


    @Test
    @DisplayName("We are able to login from Search Page")
    public void searchPageLoginTest() {
        yandexSearchPage.login(username, password);
    }

    //TODO: Прожать все линки: Видео и т.д.

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }
}
