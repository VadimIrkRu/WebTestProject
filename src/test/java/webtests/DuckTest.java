package webtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

@Epic("Тестирование DuckDuckGo")
@Feature("Поиск и проверка результата")
public class DuckTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Поиск 'стол' и проверка результата")
    void searchStol() {
        openDuckDuckGo();
        performSearch("стол");
        checkSearchResult("стол");
    }

    @Step("Открытие DuckDuckGo")
    private void openDuckDuckGo() {
        open("https://duckduckgo.com");
    }

    @Step("Поиск запроса: {query}")
    private void performSearch(String query) {
        // Проверенный селектор для поля поиска
        $(byCssSelector("#searchbox_input")).setValue(query).pressEnter();
    }

    @Step("Проверка результата с текстом {text}")
    private void checkSearchResult(String text) {
        // Проверенный селектор для результата
        $(byCssSelector("span.EKtkFWMYpwzMKOYr0GYm.LQVY1Jpkk8nyJ6HBWKAk")).shouldHave(text("стол"));
    }
}