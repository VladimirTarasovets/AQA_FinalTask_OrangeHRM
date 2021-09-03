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
public class AddAndDeleteUserViaAdminTest extends BeAfAll {

    LoginTest loginTest = new LoginTest();
    PageElement pageElement = new PageElement();
    PIMAddEmployeePage pimAddEmployeePage = new PIMAddEmployeePage();
    AdminAddUserPage adminAddUserPage = new AdminAddUserPage();
    PIMEmployeeListPage pimEmployeeListPage = new PIMEmployeeListPage();
    Properties prop = new Properties();

    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест Add user")
    @Feature("Тест на добавление пользователя (Admin \\ Add user)")
    @Issue("FT006")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
    @Test
    @Order(1)
    @DisplayName("Тест на добавление пользователя (Admin \\ Add user)")
    public void addUser() throws IOException {
        loginTest.testLogin();
        pimAddEmployeePage.openAddEmployee();
        pimAddEmployeePage.addFirstName();
        pimAddEmployeePage.addLastName();
        pimAddEmployeePage.addMiddleName();
        pimAddEmployeePage.addEmployeeId();
        pimAddEmployeePage.btnSave();
        adminAddUserPage.openUser();
        adminAddUserPage.btnAdd();
        adminAddUserPage.userRoleAdmin();
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        adminAddUserPage.employeeName(prop.getProperty("pim.employeeName"));
        adminAddUserPage.userName(prop.getProperty("pim.userName"));
        adminAddUserPage.statusEnable();
        adminAddUserPage.password(prop.getProperty("pim.userPassword"));
        adminAddUserPage.confirmPassword(prop.getProperty("pim.userPassword"));
        pageElement.getBtnSave().click();
        Assertions.assertTrue(adminAddUserPage.checkingTheAddedUser("Tarasavets"), "Пользователь не создан");

    }

    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест Add user")
    @Feature("Тест на удаление пользователя (Admin \\ Add user)")
    @Issue("FT007")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
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
    @Feature("Тест на удаление пользователя Employee")
    @Issue("FT008")
    @Link("https://github.com/VladimirTarasovets")
    @Owner("Vladimir Tarasovets")
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
