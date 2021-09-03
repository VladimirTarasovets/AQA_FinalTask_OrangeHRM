package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pageElement.PageElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RecruitmentPage {

    private static final SelenideElement firstName = $("#addCandidate_firstName");
    private static final SelenideElement middleName = $("#addCandidate_middleName");
    private static final SelenideElement lastName = $("#addCandidate_lastName");
    private static final SelenideElement email = $("#addCandidate_email");
    private static final SelenideElement contactNo = $("#addCandidate_contactNo");
    private static final SelenideElement jobVacancy = $("#addCandidate_vacancy");
    private static final SelenideElement resume = $("#addCandidate_resume");
    private static final SelenideElement keyWords = $("#addCandidate_keyWords");
    private static final SelenideElement comment = $("#addCandidate_comment");
    private static final SelenideElement dateOfApplication = $("#addCandidate_appliedDate");
    private static final SelenideElement checkboxConsentToKeepData = $("#addCandidate_consentToKeepData");
    private static final ElementsCollection message = $$(".message");


    PageElement pageElement = new PageElement();
    public static final String PICTURE = new File("src/main/resources/Speka.jpg").getAbsolutePath();


    @Step("Открытие страницы Recruitment")
    public void openRecruitmentPage () {
        pageElement.getRecruitment().click();
    }

    @Step("Нажатие кнопки Add")
    public void btnAdd () {
        pageElement.getBtnAdd().click();
    }

    @Step("Заполнение поля First Name")
    public void addFirstName (String FirstName) {
        firstName.sendKeys(FirstName);
    }

    @Step("Заполнение поля Middle Name")
    public void addMiddleName (String MiddleName) {
        middleName.sendKeys(MiddleName);
    }

    @Step("Заполнение поля Last Name")
    public void addLastName (String LastName) {
        lastName.sendKeys(LastName);
    }

    @Step("Заполнение поля Email")
    public void addEmail (String Email) {
        email.sendKeys(Email);
    }

    @Step("Заполнение поля Contact No")
    public void addContactNo (String ContactNo) {
        contactNo.sendKeys(ContactNo);
    }

    @Step("Выбор Job Vacancy")
    public void addJobVacancy (String JobVacancy) {
        jobVacancy.selectOptionByValue(JobVacancy);
    }

    @Step("Добавление файла Resume")
    public void addResume () {
        resume.sendKeys(PICTURE);
    }

    @Step("Заполнение поля Keywords")
    public void addKeywords (String Keywords) {
        keyWords.sendKeys(Keywords);
    }

    @Step("Заполнение поля Comment")
    public void addComment (String Comment) {
        comment.sendKeys(Comment);
    }

    @Step("Заполнение поля DateOfApplication")
    public void addDateOfApplication (String DateOfApplication) {
        dateOfApplication.clear();
        dateOfApplication.selectOptionByValue(DateOfApplication);
        $("#addCandidateHeading").click();
    }

    @Step("Галочка на Consent to keep data")
    public void consentToKeepData () {
        checkboxConsentToKeepData.click();
    }

    @Step("Нажатие конки Save")
    public void btnSave () {
        pageElement.getBtnSave().click();
    }

    @Step("Удаление Recruitment Candidate")
    public void deleteRecruitmentCandidate () {
        $(By.xpath("//a[text()='FirstN MiddleN LastN']/../..//input[@type='checkbox']")).click();
    }

    @Step("Нажатие кнопки Delete")
    public void btnDelete () {
        pageElement.getBtnDelete().click();
    }

    @Step("Подтверждение удаления Recruitment Candidate")
    public void btnOkDelete () {
        pageElement.getBtnOkDelete().click();
    }

    @Step("Проверка сообщения о удалении Successfully Deleted ")
    public boolean verificationSuccessfullyDeleted  () {
        message.findBy(text("Successfully Deleted ")).shouldBe(visible);
        return true;
    }

}
