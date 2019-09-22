package ru.sanchellios.prog.experiments.selenium.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ru.sanchellios.prog.experiments.selenium.yandex.Constants.*;

public class SearchPage {
    public static final String URL = "https://yandex.ru/";

    private WebDriver driver;

    @FindBy(xpath = SEARCH_PAGE_SEARCH_INPUT_XPATH)
    private WebElement searchInput;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        this.driver.get(URL);
    }

    public List<WebElement> searchFor(String searchRequest) {
        searchInput.sendKeys(searchRequest);
        searchInput.sendKeys(Keys.ENTER);
        return driver.findElements(By.xpath(SEARCH_PAGE_SEARCH_RESULT_XPATH));
    }

    public void login(String login, String password) {

    }
}
