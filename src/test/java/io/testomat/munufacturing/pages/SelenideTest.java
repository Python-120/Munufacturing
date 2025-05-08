package io.testomat.munufacturing.pages;

import base.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest extends BaseTest {

    @AfterEach
    public void close() {
        webdriver().driver().close();
    }

    @DisplayName("Authorization Test")
    @Test
    public void authorizationTest() {
        openUrl();
        loginInSystem();

        CheckResult();
    }

    @DisplayName("searchProject")
    @Test
    public void search() {
    openUrl();
    loginInSystem();
    searchProject("Home");

    checkSearchElement("Home", "Home");
    }

    @DisplayName("Project Page Test")
    @Test
    public void openProjectPage() {
        openUrl();
        loginInSystem();
        searchProject("Home");
        ClickToProject();

        checkTitle();
    }

    private static void checkTitle() {
        $(By.xpath("//div[@class='sticky-header']//h2"))
                .shouldHave(text("Home"));
    }

    private static void ClickToProject() {
        $(byText("Home")).click();
    }

    private static void checkSearchElement(String element, String text) {
        $(byText(element))
                .shouldHave(text(text));
    }

    private void searchProject(String projectName) {
        $(By.xpath("//input[@id='search']"))
                .setValue(projectName);
    }

    private static void CheckResult() {
        $x("//div[@id='container']//div[@class='common-flash-success-right']//p")
                .shouldBe(visible);

    }

    private void openUrl() {
        open(env.get("BASE_URL"));
    }

    private void loginInSystem() {
        $("#content-desktop #user_email")
                .setValue(env.get("USER_EMAIL"));
        $("#content-desktop #user_password")
                .setValue(env.get("PASSWORD"));
        //$("#content-desktop #user_remember_me").click();
        $x("//div[@id='content-desktop']//input[@value='Sign In']")
                .click();
    }

}
