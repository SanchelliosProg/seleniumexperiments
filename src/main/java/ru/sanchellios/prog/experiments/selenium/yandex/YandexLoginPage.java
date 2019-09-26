package ru.sanchellios.prog.experiments.selenium.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static ru.sanchellios.prog.experiments.selenium.Constants.*;

public class YandexLoginPage {
    public static final String URL = "https://passport.yandex.ru";

    private WebDriver driver;

    @FindBy(css = LOGIN_PAGE_SIGN_IN_BUTTON)
    private WebElement signInButton;

    public YandexLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, YandexLoginPage.class);
    }

    public void navigate() {
        driver.findElement(By.cssSelector("#passp-field-login"));
    }

    public void login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.cssSelector(LOGIN_PAGE_USERNAME_CSS));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.cssSelector(LOGIN_PAGE_PASSWORD_CSS));
        passwordInput.sendKeys(password);
    }

}
