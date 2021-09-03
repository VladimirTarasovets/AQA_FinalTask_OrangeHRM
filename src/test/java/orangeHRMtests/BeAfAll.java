package orangeHRMtests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BeAfAll {

    @BeforeEach
    @Step("Открытие страницы авторизации")
    public void setUp() {
        Configuration.headless = true;
//        Configuration.startMaximized = true;
        open("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        closeWebDriver();
    }

}
