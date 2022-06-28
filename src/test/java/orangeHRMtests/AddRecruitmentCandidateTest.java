package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageObject.RecruitmentPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddRecruitmentCandidateTest extends BeAfAll {

    LoginTest loginTest = new LoginTest();
    RecruitmentPage recruitmentPage = new RecruitmentPage();

    @Flaky
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Recruitment Candidate")
    @Test
    @Order(1)
    @DisplayName("Тест на добавление Recruitment Candidate")
    public void addRecruitmentCandidate() throws IOException {
        loginTest.testLogin();
        recruitmentPage.openRecruitmentPage();
        recruitmentPage.btnAdd();
        recruitmentPage.addFirstName("FirstN");
        recruitmentPage.addMiddleName("MiddleN");
        recruitmentPage.addLastName("LastN");
        recruitmentPage.addEmail("email@add.net");
        recruitmentPage.addContactNo("2020327");
        recruitmentPage.addJobVacancy("6");
//        recruitmentPage.addResume();  через Jenkins не добавляется
        recruitmentPage.addKeywords("Keyw");
        recruitmentPage.addComment("Comment");
//        recruitmentPage.addDateOfApplication("2021-09-05");
        recruitmentPage.consentToKeepData();
        recruitmentPage.btnSave();

    }

    @Flaky
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Recruitment Candidate")
    @Test
    @Order(2)
    @DisplayName("Тест на удаление Recruitment Candidate")
    public void deleteRecruitmentCandidate() throws IOException {
        loginTest.testLogin();
        recruitmentPage.openRecruitmentPage();
        recruitmentPage.deleteRecruitmentCandidate();
        recruitmentPage.btnDelete();
        recruitmentPage.btnOkDelete();
        Assertions.assertTrue(recruitmentPage.verificationSuccessfullyDeleted(), "Recruitment Candidate не удален");

    }

}
