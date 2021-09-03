package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageElement.PageElement;
import pageObject.LoginPanelPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BeAfAll {

    LoginPanelPage loginPanelPage = new LoginPanelPage();
    PageElement pageElement = new PageElement();

    @Flaky
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест учетной записи")
    @Feature("Вход в учетную запись")
    @Issue("FT001")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @DisplayName("Тест авторизации на сайте")
    public void testLogin() throws IOException {
        loginPanelPage.logIn();
        loginPanelPage.clickSignInButton();
        Assertions.assertTrue(pageElement.getWelcomePage().isDisplayed(), "Открыта не правильная страница");
    }

}
