package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageElement.PageElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PIMEmployeeListPage {

    private static final SelenideElement employeeList = $("#menu_pim_viewEmployeeList");
    private static final SelenideElement idEmployee = $("#empsearch_id");
    private static final SelenideElement subUnit = $("#empsearch_sub_unit");
    private static final SelenideElement searchBtn = $("#searchBtn");
    private static final SelenideElement btnDelete = $("#btnDelete");
    private static final SelenideElement btnOKDelete = $("#dialogDeleteBtn");
    private static final ElementsCollection message = $$(".message");

    private static final ElementsCollection resultTable = $$("#resultTable");
    private static final SelenideElement resultTableEl = $("#resultTable");
    private static final SelenideElement checkbox = $(By.name("chkSelectRow[]"));
    private static final SelenideElement idSales = $(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a"));

    private static final SelenideElement employeeDetails = $("#employee-details");
    private static final SelenideElement firstName = $("#personal_txtEmpFirstName");
    private static final SelenideElement middleName = $("#personal_txtEmpMiddleName");
    private static final SelenideElement lastName = $("#personal_txtEmpLastName");

    private static final SelenideElement employeeId = $("#personal_txtEmployeeId");
    private static final SelenideElement driversLicenseNumber = $("#personal_txtLicenNo");
    private static final SelenideElement numberSSN = $("#personal_txtNICNo");
    private static final SelenideElement otherID = $("#personal_txtOtherID");
    private static final SelenideElement licenseExpiryDate = $("#personal_txtLicExpDate");
    private static final SelenideElement numberSIN = $("#personal_cmbNation");
    private static final SelenideElement nationality = $("#personal_txtNICNo");
    private static final SelenideElement maritalStatus = $("#personal_cmbMarital");
    private static final SelenideElement dateOfBirth = $("#personal_DOB");
    private static final SelenideElement nickName = $("#personal_txtEmpNickName");
    private static final SelenideElement militaryService = $("#personal_txtMilitarySer");
    private static final SelenideElement personalDetailsHead = $(".head");

    public SelenideElement getPersonalDetailsHead() {
        return personalDetailsHead;
    }

    PageElement pageElement = new PageElement();


    @Step("Открытие страницы Employee List")
    public void openEmployeeList() {
        pageElement.getPim().hover();
        employeeList.click();
    }

    @Step("Выбор Sub Unit")
    public void choiceSubUnit (String SubUnitName) {
        subUnit.should(exist);
        subUnit.selectOptionByValue(SubUnitName);
    }

    @Step("Нажатие на кнопку Search")
    public void clickSearch () {
        searchBtn.should(exist);
        searchBtn.click();
    }

    @Step("Открытие первого в таблице профиля с параметром Sales")
    public void openProfile () {
        idSales.should(exist);
        idSales.click();
        employeeDetails.shouldBe(visible);
    }

    @Step("Получение значения First Name")
    public void getValueFirstName() {
        firstName.should(exist);
        String fName = firstName.getAttribute("value");
        System.out.println("First Name " + "- " + fName);
    }

    @Step("Получение значения Middle Name")
    public void getValueMiddleName() {
        middleName.should(exist);
        String mName = middleName.getAttribute("value");
        System.out.println("Middle Name " + "- " + mName);
    }

    @Step("Получение значения Last Name")
    public void getValueLastName() {
        lastName.should(exist);
        String lName = lastName.getAttribute("value");
        System.out.println("Last Name " + "- " + lName);
    }

    @Step("Получение значения Employee Id")
    public void getValueEmployeeId() {
        employeeId.should(exist);
        String eId = employeeId.getAttribute("value");
        System.out.println("Employee Id " + "- " + eId);
    }

    @Step("Получение значения Driver's License Number")
    public void getValueDriversLicenseNumber() {
        driversLicenseNumber.should(exist);
        String dLicNo = driversLicenseNumber.getAttribute("value");
        System.out.println("Driver's License Number " + "- " + dLicNo);
    }

    @Step("Получение значения SSN Number")
    public void getValueNumberSSN() {
        numberSSN.should(exist);
        String numSSN = numberSSN.getAttribute("value");
        System.out.println("SSN Number " + "- " + numSSN);
    }

    @Step("Получение значения Other Id")
    public void getValueOtherId() {
        otherID.should(exist);
        String oId = otherID.getAttribute("value");
        System.out.println("Other Id " + "- " + oId);
    }

    @Step("Получение значения License Expiry Date")
    public void getValueLicenseExpiryDate() {
        licenseExpiryDate.should(exist);
        String licExpDate = licenseExpiryDate.getAttribute("value");
        System.out.println("License Expiry Date " + "- " + licExpDate);
    }

    @Step("Получение значения SIN Number")
    public void getValueSINNumber() {
        numberSIN.should(exist);
        String sinNumber = numberSIN.getAttribute("value");
        System.out.println("SIN Number " + "- " + sinNumber);
    }

    @Step("Получение значения Nationality")
    public void getValueNationality() {
        nationality.should(exist);
        String nation = nationality.getAttribute("value");
        System.out.println("Nationality " + "- " + nation);
    }

    @Step("Получение значения Marital Status")
    public void getValueMaritalStatus() {
        maritalStatus.should(exist);
        String maritalStat = maritalStatus.getAttribute("value");
        System.out.println("Marital Status " + "- " + maritalStat);
    }

    @Step("Получение значения Date of Birth")
    public void getValueDatOfBirth() {
        dateOfBirth.should(exist);
        String dateOfBir = dateOfBirth.getAttribute("value");
        System.out.println("Date of Birth " + "- " + dateOfBir);
    }

    @Step("Получение значения Nick Name")
    public void getValueNickName() {
        nickName.should(exist);
        String nickN = nickName.getAttribute("value");
        System.out.println("Nick Name " + "- " + nickN);
    }

    @Step("Получение значения Military Service")
    public void getValueMilitaryService() {
        militaryService.should(exist);
        String militaryServ = militaryService.getAttribute("value");
        System.out.println("Military Service " + "- " + militaryServ);
    }

    @Step("Проверка значения Last Name")
    public SelenideElement getLastName() {
        return lastName;
    }

    @Step("Добавление значения ID в строку для поиска")
    public void addIdEmployeeSearch (String ID) {
        idEmployee.should(exist);
        idEmployee.clear();
        idEmployee.sendKeys(ID);
    }

    @Step("Выбор Employee с искомым значением ID")
    public void clickCheckbox () {
        checkbox.click();
    }

    @Step("Удаление Employee с искомым значением ID")
    public void deleteEmployee () {
        btnDelete.click();
    }

    @Step("Подтверждение удаления Employee с искомым значением ID")
    public void deleteOkEmployee () {
        btnOKDelete.click();
    }

    @Step("Проверка сообщения о удалении Successfully Deleted")
    public boolean verificationSuccessfullyDeleted  () {
        message.findBy(text("Successfully Deleted")).shouldBe(visible);
        return true;
    }

}
