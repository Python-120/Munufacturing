package io.testomat.munufacturing.Pages;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    private final String userName = "denismurza2016@gmail.com";
    private final String password = "qyfgy5qu";

    @DisplayName("Authorization Test")
    @Test
    public void test() {
        open("https://eu.account.battle.net/login/ru/");
        $("#accountName").setValue(userName);
        $("#password").setValue(password);
        $("#submit").click();

        $x("//div[h1]//h1[@class='title']").shouldBe(Condition.visible);
    }
}
