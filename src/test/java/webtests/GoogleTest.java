package webtests;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Epic("Тестирование Google")
public class GoogleTest {

    @Test
    @Feature("Проверка заголовка и элементов")
    void openGoogle() {
        openGooglePage();
        checkSearchField();
        checkTitle("Google");
    }

    @Step("Открытие Google")
    void openGooglePage() {
        open("https://google.com");
    }

    @Step("Проверка поля поиска")
    void checkSearchField() {
        $(byCssSelector("#APjFqb")).shouldBe(visible);
    }

    @Step("Проверка заголовка")
    void checkTitle(String expectedTitle) {
        String actualTitle = Selenide.title();
        assert actualTitle.equals(expectedTitle);
        System.out.println("Заголовок: " + actualTitle);
    }
}