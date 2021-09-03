package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageElement.PageElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LeavePage {

    private static final SelenideElement assignLeave = $("#menu_leave_assignLeave");
    private static final SelenideElement empName = $("#assignleave_txtEmployee_empName");
    private static final SelenideElement leaveType = $("#assignleave_txtLeaveType");
    private static final SelenideElement fromDate = $("#assignleave_txtFromDate");
    private static final SelenideElement toDate = $("#assignleave_txtToDate");
    private static final SelenideElement comment = $("#assignleave_txtComment");
    private static final SelenideElement assignBtn = $("#assignBtn");
    private static final SelenideElement confirmOkButton = $("#confirmOkButton");
    private static final SelenideElement leaveBalance = $("#leaveBalance_details_link");
    private static final ElementsCollection message = $$(".message");


    PageElement pageElement = new PageElement();


    @Step("Открытие страницы Assign Leave")
    public void openAssignLeave() {
        pageElement.getLeave().hover();
        assignLeave.click();
    }

    @Step("Заполнение поля First Name")
    public void addEmployeeName (String employeeName) {
        empName.should(exist);
        empName.sendKeys(employeeName);
    }

    @Step("Выбор Leave Type")
    public void addLeaveType (String leaveTyp) {
        leaveType.should(exist);
        leaveType.selectOptionByValue(leaveTyp);
    }

    @Step("Заполнение поля From Date")
    public void addFromDate (String fromDat) {
        fromDate.should(exist);
        fromDate.clear();
        fromDate.sendKeys(fromDat);
        $(".head").click();
    }

    @Step("Заполнение поля To Date")
    public void addToDate (String toDat) {
        toDate.should(exist);
        toDate.clear();
        toDate.sendKeys(toDat);
        $(".head").click();
    }

    @Step("Заполнение поля Comment")
    public void addComment (String comm) {
        comment.should(exist);
        comment.sendKeys(comm);
    }

    @Step("Нажатие кнопки Assign")
    public void clickAssign () {
        assignBtn.should(exist);
        assignBtn.click();
    }

    @Step("Нажатие кнопки подтверждения Assign")
    public void clickOkAssign () {
        confirmOkButton.click();
    }

    @Step("Проверка сообщения Successfully Assigned")
    public boolean verificationSuccessfullyAssigned () {
        message.findBy(text("Successfully Assigned")).shouldBe(visible);
        return true;
    }

}
