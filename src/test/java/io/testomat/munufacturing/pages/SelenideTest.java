package io.testomat.munufacturing.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    private final String userName = "denis.murza@icloud.com";
    private final String password = "!4fTwmTm5wAs9H2";

    @DisplayName("Authorization Test")
    @Test
    public void authorizationTest() {
        open("https://app.testomat.io");
        $("#content-desktop #user_email").setValue(userName);
        $("#content-desktop #user_password").setValue(password);
        //$("#content-desktop #user_remember_me").click();
        $x("//div[@id='content-desktop']//input[@value='Sign In']").click();

        $x("//div[@id='container']//div[@class='common-flash-success-right']//p").shouldBe(Condition.visible);
    }

}
