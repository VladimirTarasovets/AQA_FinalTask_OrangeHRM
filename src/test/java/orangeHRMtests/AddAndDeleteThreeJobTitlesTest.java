package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageElement.PageElement;
import pageObject.AdminJobPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddAndDeleteThreeJobTitlesTest extends BeAfAll {

    AdminJobPage adminJobPage = new AdminJobPage();
    PageElement pageElement = new PageElement();
    LoginTest loginTest = new LoginTest();

    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Job Title")
    @Feature("Тест на добавление 3 Job Title")
    @Issue("FT004")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @Order(1)
    @DisplayName("Тест на добавление 3 Job Title")
    public void add3JobTitles() throws IOException {
        loginTest.testLogin();
        adminJobPage.jobTitlePage();
        pageElement.getBtnAdd().click();
        adminJobPage.add3JobTitles();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Job Title")
    @Feature("Тест на удаление 3 Job Title")
    @Issue("FT005")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @Order(2)
    @DisplayName("Тест на удаление 3 Job Title")
    public void delete3JobTitles() throws IOException {
        loginTest.testLogin();
        adminJobPage.jobTitlePage();
        adminJobPage.delete3JobTitles();
        adminJobPage.deleteJob();
        adminJobPage.deleteOkJob();
        Assertions.assertTrue(adminJobPage.verificationSuccessfullyDeleted(), "Job Titles не удалены");

    }

}
