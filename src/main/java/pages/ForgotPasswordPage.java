package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "send")
    private WebElement sendResetPasswordEmailButton;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isSendResetPasswordEmailButtonVisible() {
        return sendResetPasswordEmailButton.isDisplayed();
    }
}
