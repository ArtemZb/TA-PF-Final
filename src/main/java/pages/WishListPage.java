package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class,'header')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//section[contains(@class,'productTiles')]//li")
    private List<WebElement> wishListProductItems;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public List<WebElement> getWishListProductItems() {
        return wishListProductItems;
    }

    public String getAmountOfProductsInWishList() {
        return String.valueOf(getWishListProductItems().size());
    }
}
