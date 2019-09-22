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

public class SearchTest {
    private static WebDriver driver = new ChromeDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @BeforeEach
    public void loadPage() {
        searchPage.navigate();
    }

    @Test
    @DisplayName("Search returns 16 results")
    public void sampleTest() {
        List<WebElement> searchResult = searchPage.searchFor("hip-hop");
        assertEquals(16, searchResult.size());
    }

    @Test
    @DisplayName("We are able to login from Search Page")
    public void searchPageLoginTest() {

    }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }
}
