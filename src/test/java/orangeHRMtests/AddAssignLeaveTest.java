package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageObject.LeavePage;
import pageObject.PIMAddEmployeePage;
import pageObject.PIMEmployeeListPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddAssignLeaveTest extends BeAfAll {

    LoginTest loginTest = new LoginTest();
    LeavePage leavePage = new LeavePage();
    PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
    PIMEmployeeListPage pimEmployeeListPage = new PIMEmployeeListPage();
    Properties prop = new Properties();

    @Flaky
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Assign Leave")
    @Feature("Тест на добавление Assign Leave")
    @Issue("FT012")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @Order(1)
    @DisplayName("Тест на добавление Assign Leave")
    public void addAssignLeave() throws IOException {
        loginTest.testLogin();
        pimAddEmployeePage.openAddEmployee();
        pimAddEmployeePage.addFirstName();
        pimAddEmployeePage.addLastName();
        pimAddEmployeePage.addMiddleName();
        pimAddEmployeePage.addEmployeeId();
        pimAddEmployeePage.btnSave();
        leavePage.openAssignLeave();
        leavePage.addEmployeeName("Uladzimir V Tarasavets");
        leavePage.addLeaveType("6");
        leavePage.addFromDate("2021-09-23");
        leavePage.addToDate("2021-10-08");
        leavePage.addComment("Comment");
        leavePage.clickAssign();
        Assertions.assertTrue(leavePage.verificationSuccessfullyAssigned(), "Нету подтверждения Successfully Assigned");

    }

    @Flaky
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест Assign Leave")
    @Feature("Тест на удаление Assign Leave")
    @Issue("FT013")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @Order(2)
    @DisplayName("Тест на удаление пользователя Employee")
    public void deleteEmployee() throws IOException {
        loginTest.testLogin();
        pimEmployeeListPage.openEmployeeList();
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        pimEmployeeListPage.addIdEmployeeSearch(prop.getProperty("pim.employeeId"));
        pimEmployeeListPage.clickSearch();
        pimEmployeeListPage.clickCheckbox();
        pimEmployeeListPage.deleteEmployee();
        pimEmployeeListPage.deleteOkEmployee();
        Assertions.assertTrue(pimEmployeeListPage.verificationSuccessfullyDeleted(), "Employee не удалён");

    }

}
