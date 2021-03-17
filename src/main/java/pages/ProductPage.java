package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id,'miniBagDropdown')]/a/span[contains(@class,'_1z5n7CN' )]")
    private WebElement cartProductListCount;

    @FindBy(xpath = "//button[contains(@data-test-id,'add-button')]//span[contains(@data-bind,'buttonText')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@id,'minibag-dropdown')]")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//a[contains(@data-test-id,'bag-link')]")
    private WebElement viewCartButton;

    @FindBy(xpath = "//a[contains(@data-test-id,'checkout-link')]")
    private WebElement checkoutButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public boolean isAddToCartPopupVisible() {
        return addToCartPopup.isDisplayed();
    }

    public boolean isViewCartButtonVisible() {
        return viewCartButton.isDisplayed();
    }

    public boolean isCheckOutButtonVisible() {
        return checkoutButton.isDisplayed();
    }

    public String getCartProductListCount() {
        return cartProductListCount.getText();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

}
