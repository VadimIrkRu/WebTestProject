package webtests;


import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class yahooTest {

    @Test
    void openYahoo() {

        open("https://www.yahoo.com/");
        $(byCssSelector("#ybar-sbq")).setValue("chatgpt").pressEnter();
        switchTo().window(1);
        sleep(5000);

        System.out.println("CURRENT URL: " + WebDriverRunner.url());
        System.out.println("=== PAGE SOURCE ===");
        System.out.println(WebDriverRunner.source());

        $$(byCssSelector("a[aria-label]")).findBy(text("ChatGPT")).shouldBe(visible);



    }

}
