package pageElement;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageElement {

    private static final SelenideElement welcomePage = $(By.xpath("//a[@id='welcome']"));
    private static final SelenideElement logOut = $(By.xpath("//a[text()=\"Logout\"]"));
    private static final SelenideElement admin = $("#menu_admin_viewAdminModule");
    private static final SelenideElement pim = $("#menu_pim_viewPimModule");
    private static final SelenideElement leave = $("#menu_leave_viewLeaveModule");
    private static final SelenideElement time = $("#menu_time_viewTimeModule");
    private static final SelenideElement recruitment = $("#menu_recruitment_viewRecruitmentModule");
    private static final SelenideElement myInfo = $("#menu_pim_viewMyDetails");
    private static final SelenideElement performance = $("#menu__Performance");
    private static final SelenideElement dashboard = $("#menu_dashboard_index");
    private static final SelenideElement directory = $("#menu_directory_viewDirectory");
    private static final SelenideElement maintenance = $("#menu_maintenance_purgeEmployee");
    private static final SelenideElement buzz = $("#menu_buzz_viewBuzz");

    private static final SelenideElement btnAdd = $("#btnAdd");
    private static final SelenideElement btnSave = $("#btnSave");
    private static final SelenideElement btnDelete = $("#btnDelete");
    private static final SelenideElement btnOkDelete = $("#dialogDeleteBtn");


    public SelenideElement getWelcomePage() {
        return welcomePage;
    }

    public SelenideElement getAdmin() {
        return admin;
    }

    public SelenideElement getPim() {
        return pim;
    }

    public SelenideElement getLeave() {
        return leave;
    }

    public SelenideElement getTime() {
        return time;
    }

    public SelenideElement getRecruitment() {
        return recruitment;
    }

    public SelenideElement getMyInfo() {
        return myInfo;
    }

    public SelenideElement getPerformance() {
        return performance;
    }

    public SelenideElement getDashboard() {
        return dashboard;
    }

    public SelenideElement getDirectory() {
        return directory;
    }

    public SelenideElement getMaintenance() {
        return maintenance;
    }

    public SelenideElement getBuzz() {
        return buzz;
    }

    public SelenideElement getBtnAdd() {
        return btnAdd;
    }

    public SelenideElement getBtnSave() {
        return btnSave;
    }

    public SelenideElement getBtnDelete() {
        return btnDelete;
    }

    public SelenideElement getBtnOkDelete() {
        return btnOkDelete;
    }

    @Step("Выход из учетной записи")
    public void logOut (){
        welcomePage.click();
        logOut.click();
    }

}
