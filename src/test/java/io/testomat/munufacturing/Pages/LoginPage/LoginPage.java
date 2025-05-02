package io.testomat.munufacturing.Pages.LoginPage;

import io.testomat.munufacturing.Pages.basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css="")
	private WebElement emailInput;

    @FindBy(css="")
    private WebElement passwordInput;

    @FindBy(css="")
    private WebElement rememberMeCheckbox;

    @FindBy(css="")
    private WebElement submitButton;

}
