import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void textTest() {
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();


        $("#wiki-pages-filter").setValue("Soft");
        $x("//a[text()='SoftAssertions']").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        sleep(5000);

    }
}


