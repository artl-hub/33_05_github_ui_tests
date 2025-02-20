import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;


    }

    @Test
    void dragAndDropWithActionsTest() {

        open("");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }


    @Test
    void dragAndDropWithSelenideTest(){
        open("");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }


}
