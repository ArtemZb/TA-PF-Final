package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopCartPage extends BasePage {

    @FindBy(xpath = "//h3[contains(@class,'subtotal')]")
    private WebElement subTotalPrice;

    @FindBy(xpath = "//div[contains(@class,'secondary')]//a[contains(@class,'checkout')]")
    private WebElement checkoutButton;

    public ShopCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSubTotalPriceVisible() {
        return subTotalPrice.isDisplayed();
    }

    public WebElement getSubTotalPrice() {
        return subTotalPrice;
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
