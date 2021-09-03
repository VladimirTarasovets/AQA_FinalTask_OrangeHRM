package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageElement.PageElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private static final SelenideElement quickLaunch = $("#panel_resizable_0_0");
    private static final SelenideElement assignLeaveQuickLaunch = $(By.xpath("//span[text()=\"Assign Leave\"]"));
    private static final SelenideElement leaveListQuickLaunch = $(By.xpath("//span[text()=\"Leave List\"]"));
    private static final SelenideElement timesheetsQuickLaunch = $(By.xpath("//span[text()=\"Timesheets\"]"));
    private static final SelenideElement applyLeaveQuickLaunch = $(By.xpath("//span[text()=\"Apply Leave\"]"));
    private static final SelenideElement myLeaveQuickLaunch = $(By.xpath("//span[text()=\"My Leave\"]"));
    private static final SelenideElement myTimesheetQuickLaunch = $(By.xpath("//span[text()=\"My Timesheet\"]"));
    private static final SelenideElement employeeDistributionBySubunit = $("#panel_draggable_1_0");
    private static final SelenideElement legend = $("#panel_draggable_1_1");
    private static final SelenideElement pendingLeaveRequests = $("#panel_draggable_1_2");
    private static final SelenideElement dashboardHead = $(".head");

    public SelenideElement getDashboardHead() {
        return dashboardHead;
    }

    PageElement pageElement = new PageElement();

    @Step("Открытие страницы Dashboard")
    public void openDashboard () {
        pageElement.getDashboard().click();
    }

    @Step("Проверка присутствия элемента Quick Launch")
    public void checkForExistenceQuickLaunch () {
        quickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Quick Launch_Assign Leave")
    public void checkForExistenceAssignLeaveQuickLaunch () {
        assignLeaveQuickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Quick Launch_Leave List")
    public void checkForExistenceLeaveListQuickLaunch () {
        leaveListQuickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Quick Launch_Timesheets")
    public void checkForExistenceTimesheetsQuickLaunch () {
        timesheetsQuickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Quick Launch_Apply Leave")
    public void checkForExistenceApplyLeaveQuickLaunch () {
        applyLeaveQuickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Quick Launch_My Leave")
    public void checkForExistenceMyLeaveQuickLaunch () {
        myLeaveQuickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Quick Launch_My Timesheet")
    public void checkForExistenceMyTimesheetQuickLaunch () {
        myTimesheetQuickLaunch.should(exist);
    }

    @Step("Проверка присутствия элемента Employee Distribution By Subunit")
    public void checkForExistenceEmployeeDistributionBySubunit () {
        employeeDistributionBySubunit.should(exist);
    }

    @Step("Проверка присутствия элемента Legend")
    public void checkForExistenceLegend () {
        legend.should(exist);
    }

    @Step("Проверка присутствия элемента Pending Leave Requests")
    public void checkForExistencePendingLeaveRequests () {
        pendingLeaveRequests.should(exist);
    }


}
