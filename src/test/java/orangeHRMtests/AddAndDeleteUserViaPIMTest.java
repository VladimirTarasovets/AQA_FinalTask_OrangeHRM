package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageElement.PageElement;
import pageObject.AdminAddUserPage;
import pageObject.PIMAddEmployeePage;
import pageObject.PIMEmployeeListPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddAndDeleteUserViaPIMTest extends BeAfAll {

    PageElement pageElement = new PageElement();
    LoginTest loginTest = new LoginTest();
    PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
    AdminAddUserPage adminAddUserPage = new AdminAddUserPage();
    PIMEmployeeListPage pimEmployeeListPage = new PIMEmployeeListPage();
    Properties prop = new Properties();

    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест Add Employee")
    @Test
    @Order(1)
    @DisplayName("Тест на добавление пользователя (PIM \\ Add Employee)")
    public void addUserViaPIM() throws IOException {
        loginTest.testLogin();
        pimAddEmployeePage.openAddEmployee();
        pimAddEmployeePage.addFirstName();
        pimAddEmployeePage.addLastName();
        pimAddEmployeePage.addMiddleName();
        pimAddEmployeePage.addEmployeeId();
        pimAddEmployeePage.clickCheckbox();
        pimAddEmployeePage.addUserName();
        pimAddEmployeePage.addUserPassword();
        pimAddEmployeePage.confirmUserPassword();
        pimAddEmployeePage.choiceStatus("Enabled");
        pimAddEmployeePage.btnSave();
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        Assertions.assertEquals(pimEmployeeListPage.getLastName().getAttribute("value"),
                prop.getProperty("pim.lastName"), "Пользователь не создан");

    }

    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест Add Employee")
    @Test
    @Order(2)
    @DisplayName("Тест на удаление пользователя (Admin \\ Delete user)")
    public void deleteUser() throws IOException {
        loginTest.testLogin();
        pageElement.getAdmin().click();
        adminAddUserPage.choiceDeleteUser("Tarasavets");
        adminAddUserPage.clickSearch();
        adminAddUserPage.userChoice();
        adminAddUserPage.deleteUser();
        adminAddUserPage.deleteUserOK();
        Assertions.assertTrue(adminAddUserPage.verificationSuccessfullyDeleted(), "Пользователь не удалён");

    }

    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест Employee")
    @Test
    @Order(3)
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
