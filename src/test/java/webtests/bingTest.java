package webtests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Epic("Проверка функционала поиска")
@Feature("Поиск по ключевым словам")
@Story("Поиск по запросу London")

public class bingTest {
    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    void openBing() {
        open("https://www.bing.com/");
        $(By.cssSelector("#sb_form_q")).setValue("London").pressEnter();
        $(".b_lineclamp3").shouldBe(visible);
        $$(By.cssSelector(".b_lineclamp3")).findBy(matchText("(?i).*london.*")).shouldHave(text("London"));


    }
}
