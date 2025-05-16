import com.codeborne.selenide.*;
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
import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.nio.channels.Selector.open;

public class dopsnew {

//tt
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
        $(byText("Россия")).click();

//norm


        //WebElement stranaPoezdki = wait.until(ExpectedConditions.elementToBeClickable(ByText"Страна поездки")));
        //stranaPoezdki.click();
        // stranaPoezdki.sendKeys("testfspavelclient@yandex.ru");


        //$(byText("Страна поездки")).click();
        //  $(byText("Россия")).click();
        //  $(byText("Выбрать")).click();
    }

    @Test
    void ostrovokTest() {
        Configuration.browser = "chrome"; // <--- важно
        Configuration.pageLoadStrategy = "none"; // или "none", если хочешь ускорить

        Selenide.open("https://ostrovok.ru/");

        $("[class=Control-module__value--1KWj3]").click();
    }


    @Test
    void fsLogin2()
    {

        Configuration.browser = "chrome"; // <--- важно
        Configuration.pageLoadStrategy = "none"; // или "none", если хочешь ускорить
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "normal";
        sleep(3000);
        Selenide.open("https://fstravel.com/searchexcursions");

        $("[class=v-icon-user-14]").click(); // Открываем попап Лк
        $("[type=email]").setValue("testfspavelclient@yandex.ru"); // Вводим логин
        $("[type=password]").setValue("Abonent13!");$("[type=submit]").click();  // Вводим пароль

System.out.println("Авторизация выполнена");


        $("div[class=v-departure__pinput]").click(); // Открываем попап Страна поездки
        sleep(1500);
        $(byText("Турция")).click(); // Выбираем Турцию
        $("div[class=calendar__field-dates]").click(); // Открываем Календарь
        $("[class=calendar-popup__arrow-right]").click();  //Промотка календаря
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $("[class=calendar-popup__arrow-right]").click();
        $(byText("12")).click();  // Выбираем дату в Календаре 12
        $(byText("13")).click();  // Выбираем дату в Календаре 13
        $("span[class=tourists__title]").click(); // Открывает Попап с количеством туристов
   $("span.v-icon-minus_square").shouldBe(Condition.visible).click(); // Уменьшаем количество туристов в Попапе до одного
        $("button.v-search-button").click(); // Нажимаем поиск

        System.out.println("Поиск выполнен");

        sleep(2000);



        ElementsCollection cards_of_vidacha = $$("div.excursion-card__content").shouldHave(CollectionCondition.sizeGreaterThan(1));  // Ждём, пока появятся карточки
        cards_of_vidacha.get(1).$("button").click();  // Кликаем на кнопку внутри второй карточки
      //  $(byText("Выбор")).click();


        $("[data-v-26c18107].calendar__field-dates").click();  // разобрать команду
        $$("[data-v-26c18107].calendar-popup__text").findBy(Condition.text("13")).click();
      // $("button[class=excursion-modal-main__buttons-btn]").shouldBe(Condition.visible).click();
       sleep(2000);
     //   $("button[class=excursion-modal-main__buttons-btn]").shouldBe(Condition.visible).click();

        //  $(byText("Выбрать")).shouldBe(Condition.visible).click();
       // $("")



        //  $("(//div[contains(@class,'excursion-card__content')])[1] //button").shouldBe(Condition.visible).click();
//$("(//div[contains(@class,'excursion-card__content')])[2] //button)])").click




    //    $("[class=v-search-button]").click();
      //  System.out.println("Поиск выполнен");


       // WebElement iconMinus = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class=v-icon-minus_square]")));
       // iconMinus.click();


       // $(byText("12")).click();
       // $(byText("2")).click();  //выбор количества ночей
       // $(byText("2")).click();
       // $("[data-testid=tours_searchblock_field_tourists_popup_Adminus]").click();  //уменьшение количества туристов
       // $("[data-testid=tours_searchblock_search_btn]").click();  //выполнение поиска




//$("div[class=v-departure__pinput]").click();
//$(byText("Россия")).click();
//sleep(3000);


    }

}




