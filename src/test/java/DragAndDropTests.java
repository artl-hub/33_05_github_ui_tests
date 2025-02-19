import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void dragAndDropWithActions() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }



    @Test
    void dragAndDropWithSelenide(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }


}
