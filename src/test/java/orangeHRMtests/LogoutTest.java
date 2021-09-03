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
public class LogoutTest extends BeAfAll {

    LoginTest loginTest = new LoginTest();
    PageElement pageElement = new PageElement();
    LoginPanelPage loginPanelPage = new LoginPanelPage();

    @Severity(SeverityLevel.NORMAL)
    @Description("Тест учетной записи")
    @Feature("Выход из учетной записи")
    @Issue("FT018")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @DisplayName("Выход из учетной записи")
    public void logOut() throws IOException {
        loginTest.testLogin();
        pageElement.logOut();
        Assertions.assertTrue(loginPanelPage.getLogInPanelHeading().isDisplayed(), "Открыта не правильная страница");
    }

}
