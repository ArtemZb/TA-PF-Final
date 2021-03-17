package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LogInPage getLogInPage() {
        return new LogInPage(driver);
    }

    public RegisterPage getRegisterPage() {
        return new RegisterPage(driver);
    }

    public ForgotPasswordPage getForgotPasswordPage() {
        return new ForgotPasswordPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

    public ShopCartPage getShopCartPage() {
        return new ShopCartPage(driver);
    }

    public MobileAppsPage getMobileAppsPage() {
        return new MobileAppsPage(driver);
    }
}
