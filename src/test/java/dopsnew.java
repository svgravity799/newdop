import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.nio.channels.Selector.open;

public class dopsnew {


    @Test
    void fsLogin() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);  // Не ждём полной загрузки страницы

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://fstravel.com/searchexcursions");

        // Ожидаем, пока элемент с иконкой пользователя станет доступным
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=v-icon-user-14]")));
        // Теперь можно работать с элементом
        el.click(); // или что угодно

        // Ожидаем, пока появится поле для ввода email и кликаем по нему
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type=email]")));
        emailField.click();
        emailField.sendKeys("testfspavelclient@yandex.ru");

        // Ожидаем, пока появится поле для ввода пароля и вводим данные
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id=password]")));
        passwordField.sendKeys("Abonent13!");

        // Ожидаем, пока не станет доступной кнопка или элемент формы и кликаем по нему
        WebElement formGroup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type=submit]")));
        formGroup.click();

        sleep(3000);

        System.out.println("Авторизация выполнена");

        WebElement countrySearch = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=v-departure__pinput]")));
        countrySearch.click();




        //WebElement stranaPoezdki = wait.until(ExpectedConditions.elementToBeClickable(ByText"Страна поездки")));
        //stranaPoezdki.click();
        // stranaPoezdki.sendKeys("testfspavelclient@yandex.ru");


        //$(byText("Страна поездки")).click();
        //  $(byText("Россия")).click();
        //  $(byText("Выбрать")).click();
    }




}