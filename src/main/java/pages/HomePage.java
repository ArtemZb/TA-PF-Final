package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@id,'header')]")
    private WebElement header;

    @FindBy(xpath = "//div[contains(@id,'AccountDropdown')]")
    private WebElement accountOptionsDropdown;

    @FindBy(xpath = "//a[contains(@data-testid,'signin')]")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains(@data-testid,'signup')]")
    private WebElement registerButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@data-testid,'search-button')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@id,'footer')]")
    private WebElement footer;

    @FindBy(xpath = "//a[contains(@href,'instagram')]")
    private WebElement instagram;

    @FindBy(xpath = "//a[contains(@href,'facebook')]")
    private WebElement facebook;

    @FindBy(xpath = "//a[contains(@href,'snapchat')]")
    private WebElement snapchat;

    @FindBy(xpath = "//footer//a[contains(@href,'apps')]")
    private WebElement shopMobileApplications;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void clickSignInButton() {
        Actions action = new Actions(driver);
        action.moveToElement(accountOptionsDropdown).build().perform();
        waitVisibilityOfElement(60, signInButton);
        signInButton.click();
    }

    public void clickRegisterButton() {
        Actions action = new Actions(driver);
        action.moveToElement(accountOptionsDropdown).build().perform();
        waitVisibilityOfElement(60, registerButton);
        registerButton.click();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public boolean isSearchButtonEnabled() {
        return searchButton.isEnabled();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }


    public void clickOnSocialApp(String socialApp) {
        switch (socialApp) {
            case "instagram" -> instagram.click();
            case "facebook" -> facebook.click();
            case "snapchat" -> snapchat.click();
            default -> throw new IllegalStateException("Unexpected value: " + socialApp);
        }
    }

    public void clickShopMobileApplications() {
        shopMobileApplications.click();
    }

}
