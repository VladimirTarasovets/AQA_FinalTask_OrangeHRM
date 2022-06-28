package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageElement.PageElement;
import pageObject.AdminJobPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddAndDeleteOneJobTitlesTest extends BeAfAll {

    AdminJobPage adminJobPage = new AdminJobPage();
    PageElement pageElement = new PageElement();
    LoginTest loginTest = new LoginTest();

    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Job Title")
    @Test
    @DisplayName("Тест на добавление 1 Job Title")
    public void addJobTitles() throws IOException {
        loginTest.testLogin();
        adminJobPage.jobTitlePage();
        pageElement.getBtnAdd().click();
        adminJobPage.jobTitleField("AQA Engineer");
        adminJobPage.jobDescription("Job");
//        adminJobPage.jobSpecification();  через Jenkins не добавляется
        adminJobPage.note("Note");
        pageElement.getBtnSave().click();
        Assertions.assertTrue(adminJobPage.checkingTheAddedJob("AQA Engineer"), "Job Title не создана");

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Job Title")
    @Test
    @DisplayName("Тест на удаление 1 Job Title")
    public void deleteJobTitles() throws IOException {
        loginTest.testLogin();
        adminJobPage.jobTitlePage();
        adminJobPage.checkbox1();
        adminJobPage.deleteJob();
        adminJobPage.deleteOkJob();
        Assertions.assertTrue(adminJobPage.verificationSuccessfullyDeleted(), "Job Title не удалена");

    }

}
