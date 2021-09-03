package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pageElement.PageElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class PIMAddEmployeePage {

    private static final SelenideElement employee = $("#menu_pim_viewEmployeeList");
    private static final SelenideElement addEmployee = $("#menu_pim_addEmployee");
    private static final SelenideElement firstName = $("#firstName");
    private static final SelenideElement middleName = $("#middleName");
    private static final SelenideElement lastName = $("#lastName");
    private static final SelenideElement employeeId = $("#employeeId");
    private static final SelenideElement chkLogin = $("#chkLogin");
    private static final SelenideElement userName = $("#user_name");
    private static final SelenideElement userPassword = $("#user_password");
    private static final SelenideElement confirmPassword = $("#re_password");
    private static final SelenideElement status = $("#status");


    PageElement pageElement = new PageElement();
    Properties prop = new Properties();


    @Step("Открытие страницы Add Employee")
    public void openAddEmployee() {
        pageElement.getPim().hover();
        addEmployee.click();
    }

    @Step("Добавление First Name")
    public void addFirstName () throws IOException {
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        firstName.should(exist);
        firstName.sendKeys(prop.getProperty("pim.firstName"));
    }

    @Step("Добавление Middle Name")
    public void addMiddleName () throws IOException{
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        middleName.should(exist);
        middleName.sendKeys(prop.getProperty("pim.middleName"));
    }

    @Step("Добавление Last Name")
    public void addLastName () throws IOException{
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        lastName.should(exist);
        lastName.sendKeys(prop.getProperty("pim.lastName"));
    }

    @Step("Добавление employee Id")
    public void addEmployeeId () throws IOException{
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        employeeId.should(exist);
        employeeId.clear();
        employeeId.sendKeys(prop.getProperty("pim.employeeId"));
    }

    @Step("Клик по checkbox Create Login Details")
    public void clickCheckbox () {
        chkLogin.should(exist);
        chkLogin.click();
    }

    @Step("Добавление User Name")
    public void addUserName () throws IOException{
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        userName.should(exist);
        userName.sendKeys(prop.getProperty("pim.userName"));
    }

    @Step("Добавление User Password")
    public void addUserPassword () throws IOException{
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        userPassword.should(exist);
        userPassword.sendKeys(prop.getProperty("pim.userPassword"));
    }

    @Step("Подтверждение User Password")
    public void confirmUserPassword () throws IOException{
        prop.load(new FileInputStream("src/main/resources/pim.properties"));
        confirmPassword.should(exist);
        confirmPassword.sendKeys(prop.getProperty("pim.userPassword"));
    }

    @Step("Выбор статуса пользователя")
    public void choiceStatus (String Status) {
        status.should(exist);
        status.selectOptionByValue(Status);
    }

    @Step("Нажатие кнопки Save")
    public void btnSave() {
        pageElement.getBtnSave().click();
    }

}
