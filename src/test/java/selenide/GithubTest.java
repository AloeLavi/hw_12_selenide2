package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @Test
    void solutionsTest() {

        open("https://github.com");
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $(byText("Build like the best")).shouldBe(visible);

    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //проверяем что в колонке1=А, в колонке2=В
        $(("#column-a")).shouldHave(text("A"));
        $(("#column-b")).shouldHave(text("B"));

        // actions не удалось заставить работать
     //   actions().moveToElement($(byText("A"))).clickAndHold().moveToElement($(byText("B"))).release().perform();
        $(byText("A")).dragAndDropTo($(byText("B")));

        //проверяем что в колонке1=B, в колонке2=A
        $(("#column-a")).shouldHave(text("B"));
        $(("#column-b")).shouldHave(text("A"));

        sleep(3000);
    }
}
