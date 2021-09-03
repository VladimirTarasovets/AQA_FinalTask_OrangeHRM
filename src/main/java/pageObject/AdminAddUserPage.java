package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageElement.PageElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AdminAddUserPage {

    private static final SelenideElement userManagement = $("#menu_admin_UserManagement");
    private static final SelenideElement user = $("#menu_admin_viewSystemUsers");
    private static final SelenideElement userRole = $("#systemUser_userType");
    private static final SelenideElement employeeName = $("#systemUser_employeeName_empName");
    private static final SelenideElement userName = $("#systemUser_userName");
    private static final SelenideElement status = $("#systemUser_status");
    private static final SelenideElement password = $("#systemUser_password");
    private static final SelenideElement confirmPassword = $("#systemUser_confirmPassword");
    private static final SelenideElement customerList = $("#systemUser-information");
    private static final ElementsCollection resultTable = $$("#resultTable");
    private static final SelenideElement resultTableElement = $("#resultTable");
    private static final SelenideElement searchUserName = $("#searchSystemUser_userName");
    private static final SelenideElement checkbox = $(By.xpath("//input[@name=\"chkSelectRow[]\"]"));
    private static final SelenideElement searchBtn = $("#searchBtn");
    private static final SelenideElement btnDelete = $("#btnDelete");
    private static final SelenideElement dialogDeleteBtn = $("#dialogDeleteBtn");
    private static final ElementsCollection message = $$(".message");


    public SelenideElement getCustomerList() {
        return customerList;
    }

    PageElement pageElement = new PageElement();

    @Step("Открытие страницы User")
    public void openUser() {
        pageElement.getAdmin().hover();
        userManagement.hover();
        user.click();
    }

    @Step("Нажатие кнопки Add")
    public void btnAdd () {
        pageElement.getBtnAdd().click();
    }

    @Step("Выбор роли для пользователся Admin")
    public void userRoleAdmin () {
        userRole.should(exist);
        userRole.selectOptionByValue("1");
    }

    @Step("Выбор роли для пользователся ESS")
    public void userRoleESS () {
        userRole.should(exist);
        userRole.selectOptionByValue("2");
    }

    @Step("Заполнение поля имени сотрудника")
    public void employeeName (String Name) {
        userRole.should(exist);
        employeeName.sendKeys(Name);
    }

    @Step("Заполнение поля имени пользователя")
    public void userName (String Name) {
        userRole.should(exist);
        userName.sendKeys(Name);
    }

    @Step("Выбор статуса Enable")
    public void statusEnable () {
        userRole.should(exist);
        status.sendKeys("1");
    }

    @Step("Выбор статуса Disable")
    public void statusDisable () {
        userRole.should(exist);
        status.sendKeys("0");
    }

    @Step("Заполнение поля пароля")
    public void password (String pass) {
        userRole.should(exist);
        password.sendKeys(pass);
    }

    @Step("Заполнение поля подтверждения пароля")
    public void confirmPassword (String password) {
        userRole.should(exist);
        confirmPassword.sendKeys(password);
    }

    @Step("Нажатие кнопки Save")
    public void btnSave () {
        userRole.should(exist);
        pageElement.getBtnSave().click();
    }

    @Step("Проверка создался ли пользователь")
    public boolean checkingTheAddedUser (String uName) {
        resultTable.findBy(text(uName)).should(exist);
        return true;
    }

    @Step("Введение имени удаляемого пользователя")
    public void choiceDeleteUser (String uName) {
        searchUserName.should(exist);
        searchUserName.sendKeys(uName);
    }

    @Step("Клик по кнопке Search")
    public void clickSearch () {
        searchBtn.should(exist);
        searchBtn.click();
    }

    @Step("Выбор найденного пользователя")
    public void userChoice () {
        checkbox.should(exist);
        checkbox.click();
    }

    @Step("Удаление найденного пользователя")
    public void deleteUser () {
        btnDelete.click();
    }

    @Step("Подтверждение удаления пользователя")
    public void deleteUserOK () {
        dialogDeleteBtn.shouldBe(visible);
        dialogDeleteBtn.click();
    }

    @Step("Проверка сообщения о удалении Successfully Deleted ")
    public boolean verificationSuccessfullyDeleted  () {
        message.findBy(text("Successfully Deleted")).shouldBe(visible);
        return true;
    }
}
