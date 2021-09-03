package pageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class LoginPanelPage {

    private static final SelenideElement userName = $("#txtUsername");
    private static final SelenideElement password = $("#txtPassword");
    private static final SelenideElement buttonLogin = $("#btnLogin");
    private static final SelenideElement logInPanelHeading = $("#logInPanelHeading");


    public SelenideElement getUserName() {
        return userName;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getButtonLogin() {
        return buttonLogin;
    }

    public SelenideElement getLogInPanelHeading() {
        return logInPanelHeading;
    }



    @Step("Заполнение авторизации")
    public void logIn () throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/user.properties"));
        userName.sendKeys(prop.getProperty("user.username"));
        password.sendKeys(prop.getProperty("user.password"));
    }

    @Step("Заполнение авторизации")
    public void logInSet (String setUserName, String setPassword) {
        userName.sendKeys(setUserName);
        password.sendKeys(setPassword);
    }

    @Step("Нажатие кнопки входа")
    public void clickSignInButton () {
        buttonLogin.click();
    }

}
