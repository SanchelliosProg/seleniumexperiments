package ru.sanchellios.prog.experiments.selenium.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ru.sanchellios.prog.experiments.selenium.Constants.*;

public class YandexSearchPage {

    private WebDriver driver;

    @FindBy(xpath = SEARCH_PAGE_SEARCH_INPUT_XPATH)
    private WebElement searchInput;

    @FindBy(xpath = SEARCH_PAGE_LOGIN_BUTTON_XPATH)
    private WebElement loginButton;

    @FindBy(id = SEARCH_PAGE_NEWS_PANEL_ID)
    private WebElement newsPanel;

    public YandexSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        this.driver.get(YANDEX_URL);
    }

    public List<WebElement> searchFor(String searchRequest) {
        searchInput.sendKeys(searchRequest);
        searchInput.sendKeys(Keys.ENTER);
        return driver.findElements(By.xpath(SEARCH_PAGE_SEARCH_RESULT_XPATH));
    }

    public void login(String username, String password) {
        loginButton.click();
        YandexSearchPage yandexSearchPage = new YandexSearchPage(driver);

        yandexSearchPage.login(username, password);
        loginButton.click();
    }

    public void getListOfNews() {

    }
}
