package io.testomat.munufacturing.pages;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        openUrl();
    }

    @AfterEach
    public void close() {
        closeWebDriver();
    }

    @DisplayName("Authorization Test")
    @Test
    public void authorizationTest() {
        loginInSystem();

        CheckResult();
    }

    @DisplayName("searchProject")
    @Test
    public void search() {
    loginInSystem();
    searchProject("Home");

    checkSearchElement("Home", "Home");
    }

    @DisplayName("Project Page Test")
    @Test
    public void openProjectPage() {
        loginInSystem();
        searchProject("Home");
        ClickToProject();

        checkTitle();
    }

    @DisplayName("Select option on drop-down")
    @Test
    public void selectOptionOnDropDown() {
        loginInSystem();
        selectOption("Free Projects");

        checkNoProject();
    }

    private static void checkNoProject() {
        $x("//p[contains(@class, 'mb-6')]")
                .shouldBe(visible);
    }

    private void selectOption(String option) {
        Selenide.$("#content-desktop #company_id").selectOption(option);
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
