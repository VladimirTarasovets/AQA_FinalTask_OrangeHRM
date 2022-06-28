package orangeHRMtests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageObject.PIMEmployeeListPage;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CheckTheFormWithDetailsSalesTest extends BeAfAll {

    LoginTest loginTest = new LoginTest();
    PIMEmployeeListPage pimEmployeeListPage = new PIMEmployeeListPage();

    @Severity(SeverityLevel.MINOR)
    @Description("Тест PIM")
    @Test
    @DisplayName("Проверка PIM с Sales")
    public void checkTheFormWithDetailsSales() throws IOException {
        loginTest.testLogin();
        pimEmployeeListPage.openEmployeeList();
        pimEmployeeListPage.choiceSubUnit("8");
        pimEmployeeListPage.clickSearch();
        pimEmployeeListPage.openProfile();
        pimEmployeeListPage.getValueFirstName();
        pimEmployeeListPage.getValueMiddleName();
        pimEmployeeListPage.getValueLastName();
        pimEmployeeListPage.getValueEmployeeId();
        pimEmployeeListPage.getValueDriversLicenseNumber();
        pimEmployeeListPage.getValueNumberSSN();
        pimEmployeeListPage.getValueLicenseExpiryDate();
        pimEmployeeListPage.getValueSINNumber();
        pimEmployeeListPage.getValueNationality();
        pimEmployeeListPage.getValueMaritalStatus();
        pimEmployeeListPage.getValueDatOfBirth();
        Assertions.assertTrue(pimEmployeeListPage.getPersonalDetailsHead().isDisplayed(), "Открыта не правильная страница");

    }

}
