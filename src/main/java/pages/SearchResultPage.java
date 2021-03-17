package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[contains(@data-auto-id,'productList')]/section/article")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//button[contains(@data-auto-id,'saveForLater')]")
    private List<WebElement> searchResultListWishIcon;

    @FindBy(xpath = "//span[contains(@data-auto-id,'Price')]/span")
    private List<WebElement> searchResultListPrices;

    @FindBy(xpath = "//a[contains(@data-testid,'savedItems')]")
    private WebElement wishListPageButton;

    @FindBy(xpath = "//li[@data-dropdown-id='sort']/div")
    private WebElement sortButton;

    @FindBy(xpath = "//li[@data-dropdown-id='sort']//li[contains(@id,'high_to_low')]")
    private WebElement sortByPriceDESC;

    @FindBy(xpath = "//li[@data-dropdown-id='sort']//li[contains(@id,'low_to_high')]")
    private WebElement sortByPriceASC;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultList() {
        return searchResultList;
    }

    public List<WebElement> getSearchResultListWishIcon() {
        return searchResultListWishIcon;
    }

    public boolean isSearchResultByKeywordEmpty() {
        return getSearchResultList().isEmpty();
    }

    public void clickWishListPageButton() {
        wishListPageButton.click();
    }

    public void clickWishListOnProduct(int number) {
        for (int i = 0; i < number; i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getSearchResultListWishIcon().get(i));
        }
    }

    public void clickSortButton() {
        sortButton.click();
    }

    public void clickProductItem() {
        getSearchResultList().get(0).click();
        driver.navigate().refresh();
    }

    public void sortProductListBySortOption(String sortOrder) {
        clickSortButton();
        switch (sortOrder) {
            case "priceASC" -> ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortByPriceASC);
            case "priceDESC" -> ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortByPriceDESC);
            default -> throw new IllegalStateException("Unexpected value: " + sortOrder);
        }
        driver.navigate().refresh();
    }

    public boolean isProductListSortedBySortOrder(String sortOrder) {
        return driver.getCurrentUrl().contains(sortOrder.toLowerCase());
    }

    public boolean isMinPriceRangeCorrect(String minPrice) {
        return Double.parseDouble(searchResultListPrices.get(0).getText().substring(1)) >= Double.parseDouble(minPrice);
    }

    public boolean isMaxPriceRangeCorrect(String maxPrice) {
        return Double.parseDouble(searchResultListPrices.get(searchResultListPrices.size() - 1).
                getText().substring(1)) <= Double.parseDouble(maxPrice);
    }

}
