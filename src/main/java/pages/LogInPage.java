package pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    @FindBy(id = "EmailAddress")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "signin")
    private WebElement signInButton;

    @FindBy(id = "loginErrorMessage")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//a[contains(@data-analytics,'ForgotPassword')]")
    private WebElement forgotPasswordButton;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public void enterTextToEmailField() {
        String generatedEmail = RandomStringUtils.randomAlphanumeric(8);
        emailField.sendKeys(generatedEmail + "@gmail.com");
    }

    public void enterTextToPasswordField() {
        String generatedPassword = RandomStringUtils.randomAlphanumeric(8);
        passwordField.sendKeys(generatedPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickForgotPasswordButton() {
        forgotPasswordButton.click();
    }

    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public boolean isLoginErrorMessageVisible() {
        return loginErrorMessage.isDisplayed();
    }
}
