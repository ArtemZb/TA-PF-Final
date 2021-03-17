package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "register")
    private WebElement registerButton;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "BirthDay")
    private WebElement birthDayField;

    @FindBy(id = "BirthMonth")
    private WebElement birthMonthField;

    @FindBy(id = "BirthYear")
    private WebElement birthYearField;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isFirstNameFieldVisible() {
        return firstNameField.isDisplayed();
    }

    public boolean isLastNameFieldVisible() {
        return lastNameField.isDisplayed();
    }

    public boolean isBirthDayFieldVisible() {
        return birthDayField.isDisplayed();
    }

    public boolean isBirthMonthFieldVisible() {
        return birthMonthField.isDisplayed();
    }

    public boolean isBirthYearFieldVisible() {
        return birthYearField.isDisplayed();
    }

    public boolean isPasswordFieldVisible() {
        return passwordField.isDisplayed();
    }

    public boolean isRegisteredButtonVisible() {
        return registerButton.isDisplayed();
    }
}
