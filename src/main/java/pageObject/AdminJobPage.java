package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pageElement.PageElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AdminJobPage {

    private static final SelenideElement jobPage = $("#menu_admin_Job");
    private static final SelenideElement jobTitlePage = $("#menu_admin_viewJobTitleList");
    private static final SelenideElement btnAdd = $("#btnAdd");
    private static final SelenideElement jobTitleField = $("#jobTitle_jobTitle");
    private static final SelenideElement jobDescription = $("#jobTitle_jobDescription");
    private static final SelenideElement jobSpecificationButton = $("#jobTitle_jobSpec");
    private static final SelenideElement note = $("#jobTitle_note");
    private static final SelenideElement btnSave = $("#btnSave");
    private static final ElementsCollection resultTable = $$("#resultTable");
    private static final SelenideElement checkbox1 = $(By.xpath("//a[text()='AQA Engineer']/../..//input[@type='checkbox']"));
    private static final SelenideElement btnDelete = $("#btnDelete");
    private static final SelenideElement okDelete = $("#dialogDeleteBtn");
    private static final ElementsCollection message = $$(".message");
//    private static final SelenideElement checkbox = $(By.name("chkSelectRow[]"));




    private static final String PICTURE = new File("src/main/resources/Speka.jpg").getAbsolutePath();

    PageElement pageElement = new PageElement();
    Properties prop = new Properties();


    @Step("Переход на страницу Job Title")
    public void jobTitlePage () {
        pageElement.getAdmin().hover();
        jobPage.hover();
        jobTitlePage.click();
    }

    @Step("Нажатие кнопки Add")
    public void btnAdd () {
        btnAdd.click();
    }

    @Step("Заполнение поля Job Title")
    public void jobTitleField (String JobTitleName) {
        jobTitleField.sendKeys(JobTitleName);
    }

    @Step("Заполнение поля Job Description")
    public void jobDescription (String JobDescriptionName) {
        jobDescription.sendKeys(JobDescriptionName);
    }

    @Step("Загрузка файла спецификации")
    public void jobSpecification () {
        jobSpecificationButton.sendKeys(PICTURE);
    }

    @Step("Заполнение поля Note")
    public void note (String noteName) {
        note.sendKeys(noteName);
    }

    @Step("Нажатие кнопки Save")
    public void btnSave () {
        btnSave.click();
    }

//    public void listOf () {
//        List<JobsList> listOfJobs = new ArrayList<>();
//        listOfJobs.add(new JobsList("JobTitle1"));
//        listOfJobs.add(new JobsList("JobTitle2"));
//        listOfJobs.add(new JobsList("JobTitle3"));
//
//    }

    @Step("Проверка создалась ли вакансия")
    public boolean checkingTheAddedJob (String uName) {
        resultTable.findBy(text(uName)).should(exist);
        return true;
    }

    @Step("Выбор удаляемой Job Title")
    public void checkbox1 () {
        checkbox1.click();
    }

    @Step("Нажатие кнопки Delete")
    public void deleteJob () {
        btnDelete.click();
    }

    @Step("Подтверждение удаления Job Title")
    public void deleteOkJob () {
        okDelete.click();
    }

    @Step("Проверка сообщения о удалении Successfully Deleted ")
    public boolean verificationSuccessfullyDeleted  () {
        message.findBy(text("Successfully Deleted ")).shouldBe(visible);
        return true;
    }

    @Step("Создание 3 Job Titles")
    public void add3JobTitles () throws IOException {
        prop.load(new FileInputStream("src/main/resources/jobTitle.properties"));
        jobTitleField(prop.getProperty("jt.JobTitle1"));
        pageElement.getBtnSave().click();
        Assertions.assertTrue(checkingTheAddedJob(prop.getProperty("jt.JobTitle1")),
                "Job Title 1 не создана");
        pageElement.getBtnAdd().click();
        jobTitleField(prop.getProperty("jt.JobTitle2"));
        pageElement.getBtnSave().click();
        Assertions.assertTrue(checkingTheAddedJob(prop.getProperty("jt.JobTitle2")),
                "Job Title 2 не создана");
        pageElement.getBtnAdd().click();
        jobTitleField(prop.getProperty("jt.JobTitle3"));
        pageElement.getBtnSave().click();
        Assertions.assertTrue(checkingTheAddedJob(prop.getProperty("jt.JobTitle3")),
                "Job Title 3 не создана");
    }

    @Step("Удаление 3 Job Titles")
    public void delete3JobTitles () {
//        prop.load(new FileInputStream("src/main/resources/jobTitle.properties"));
//        String jt1 = (prop.getProperty("jt.JobTitle1"));
//        String jt2 = (prop.getProperty("jt.JobTitle2"));
//        String jt3 = (prop.getProperty("jt.JobTitle3"));

        $(By.xpath("//a[text()='Job Title 1']/../..//input[@type='checkbox']")).click();
        $(By.xpath("//a[text()='Job Title 2']/../..//input[@type='checkbox']")).click();
        $(By.xpath("//a[text()='Job Title 3']/../..//input[@type='checkbox']")).click();

    }

}
