package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileAppsPage extends BasePage {

    @FindBy(xpath = "//main//h1")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'shop-app1')]")
    private WebElement iPhoneAppButton;

    @FindBy(xpath = "//div[contains(@class,'shop-app3')]")
    private WebElement androidAppButton;

    public MobileAppsPage(WebDriver driver) {
        super(driver);
    }

    public void clickIPhoneAppButton() {
        iPhoneAppButton.click();
    }

    public void clickAndroidAppButton() {
        androidAppButton.click();
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public boolean isPageTitleVisible() {
        return pageTitle.isDisplayed();
    }

    public void clickMobileApplication(String appOption) {
        switch (appOption) {
            case "android" -> androidAppButton.click();
            case "iPhone" -> iPhoneAppButton.click();
            default -> throw new IllegalStateException("Unexpected value: " + appOption);
        }
    }
}
