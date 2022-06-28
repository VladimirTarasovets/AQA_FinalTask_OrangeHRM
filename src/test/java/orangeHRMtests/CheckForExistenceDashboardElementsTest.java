package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageObject.DashboardPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckForExistenceDashboardElementsTest extends BeAfAll {

    LoginTest loginTest = new LoginTest();
    DashboardPage dashboardPage = new DashboardPage();

    @Severity(SeverityLevel.MINOR)
    @Description("Тест Dashboard")
    @Test
    @DisplayName("Проверка Dashboard на присутствие элементов")
    public void checkForExistenceDashboardElements() throws IOException {
        loginTest.testLogin();
        dashboardPage.openDashboard();
        dashboardPage.checkForExistenceQuickLaunch();
        dashboardPage.checkForExistenceAssignLeaveQuickLaunch();
        dashboardPage.checkForExistenceLeaveListQuickLaunch();
        dashboardPage.checkForExistenceTimesheetsQuickLaunch();
        dashboardPage.checkForExistenceApplyLeaveQuickLaunch();
        dashboardPage.checkForExistenceMyLeaveQuickLaunch();
        dashboardPage.checkForExistenceMyTimesheetQuickLaunch();
        dashboardPage.checkForExistenceEmployeeDistributionBySubunit();
        dashboardPage.checkForExistenceLegend();
        dashboardPage.checkForExistencePendingLeaveRequests();
        Assertions.assertTrue(dashboardPage.getDashboardHead().isDisplayed(), "Открыта не правильная страница");

    }

}
