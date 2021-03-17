package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 120;
    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;
    ProductPage productPage;
    SearchResultPage searchResultPage;
    WishListPage wishListPage;
    ShopCartPage shopCartPage;
    MobileAppsPage mobileAppsPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void OpenPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openPage(url);
    }

    @And("User checks the footer visibility")
    public void checkFooterVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isFooterVisible();
    }

    @And("User checks the header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User enters email and password of non-existing user")
    public void enterEmailPasswordOnLogInPage() {
        logInPage.enterTextToEmailField();
        logInPage.enterTextToPasswordField();
    }

    @And("Users clicks 'Sign In' button on the Log In page")
    public void clickSignInButtonOnLogInPage() {
        logInPage.clickSignInButton();
    }

    @And("User clicks on 'Join' button")
    public void clickRegisterButton() {
        homePage.clickRegisterButton();
    }

    @And("Users checks 'Join ASOS' button visibility")
    public void checkRegisterButtonVisibilityOnRegistrationPage() {
        assertTrue(registerPage.isRegisteredButtonVisible());
    }

    @And("User clicks on the 'Forgot Password' button")
    public void clickForgotPasswordButton() {
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        logInPage.clickForgotPasswordButton();
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @And("User checks 'Search' button is disabled by default")
    public void checkSearchButtonIsDisabled() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertFalse(homePage.isSearchButtonEnabled());
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }


    @And("User clicks 'Wishlist' icon on {string}")
    public void clickWishListOnProduct(final String number) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickWishListOnProduct(Integer.parseInt(number));
    }

    @And("User clicks on the Wish List Page button")
    public void clickWishListPageButton() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickWishListPageButton();
    }

    @And("User checks that products are sorted correctly according to {string}")
    public void checkProductListHasCorrectSortOrder(String sortOrder) {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultPage.isProductListSortedBySortOrder(sortOrder));
    }

    @And("User clicks on Product item")
    public void clickProductItem() {
        searchResultPage.clickProductItem();
    }
    @And("User clicks on 'Add to bag' button")
    public void clickAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User checks that add to cart popup visible")
    public void checkAddToCartPopupVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getAddToCartPopup());
        assertTrue(productPage.isAddToCartPopupVisible());
    }

    @And("User checks 'View Bag' button visibility")
    public void checkViewCartButtonVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getAddToCartPopup());
        assertTrue(productPage.isViewCartButtonVisible());
        assertTrue(productPage.isCheckOutButtonVisible());
    }

    @And("User checks 'Checkout' button visibility")
    public void checkCheckoutButtonVisibility() {
        productPage.isCheckOutButtonVisible();
    }

    @And("User clicks 'View Bag' button")
    public void clickViewCartButton() {
        productPage.clickViewCartButton();
    }

    @And("User checks the total price visibility")
    public void checkTotalPriceVisibility() {
        shopCartPage = pageFactoryManager.getShopCartPage();
        shopCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shopCartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,shopCartPage.getSubTotalPrice());
        assertTrue(shopCartPage.isSubTotalPriceVisible());
    }

    @And("User clicks 'Checkout' button")
    public void clickCheckoutButton() {
        shopCartPage.clickCheckoutButton();
    }

    @And("User checks the 'DOWNLOAD THE ASOS APP' page is displayed")
    public void checkDownloadMobileAppsPageVisibility(){
        mobileAppsPage = pageFactoryManager.getMobileAppsPage();
        mobileAppsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,mobileAppsPage.getPageTitle());
        assertTrue(mobileAppsPage.isPageTitleVisible());
    }

    @And("User checks the {string} for download is displayed")
    public void checkMobileAppSiteIsOpened(final String url){
        mobileAppsPage.waitForNumberWindowsToBe(DEFAULT_TIMEOUT,2);
        mobileAppsPage.switchToWindow(1);
        mobileAppsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(mobileAppsPage.getCurrentWindowURL(), url);
    }

    @When("User clicks on a {string}")
    public void clickOnSocialApp(final String socialApp) {
        homePage.clickOnSocialApp(socialApp);
    }

    @When("User clicks on 'Sign In' button")
    public void clickSingInButton() {
        homePage.clickSignInButton();
    }

    @When("User clicks on 'Mobile and ASOS Apps' button")
    public void clickDownloadMobileAppsButton() {
        homePage.clickShopMobileApplications();
    }

    @When("User makes search by keyword {string}")
    public void enterKeywordToSearchField(final String searchText) {
        homePage.enterTextToSearchField(searchText);
    }

    @Then("User checks that they are redirected to the {string}")
    public void checkSocialAppSiteDisplayed(final String socialAppSite) {
        homePage.waitForNumberWindowsToBe(DEFAULT_TIMEOUT, 2);
        homePage.switchToWindow(1);
        assertTrue(homePage.getCurrentWindowURL().contains(socialAppSite));
    }

    @Then("User checks email and password fields visibility on the login form")
    public void checkLogInFieldsVisibility() {
        logInPage = pageFactoryManager.getLogInPage();
        logInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(logInPage.isEmailFieldVisible());
        assertTrue(logInPage.isPasswordFieldVisible());
    }

    @Then("User checks that the validation error popup is displayed")
    public void checkLogInErrorMessageVisibility() {
        logInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, logInPage.getLoginErrorMessage());
        assertTrue(logInPage.isLoginErrorMessageVisible());
    }

    @Then("User checks fields visibility on the registration form")
    public void checkRegistrationPageFieldsVisibility() {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(registerPage.isEmailFieldVisible());
        assertTrue(registerPage.isPasswordFieldVisible());
        assertTrue(registerPage.isFirstNameFieldVisible());
        assertTrue(registerPage.isLastNameFieldVisible());
        assertTrue(registerPage.isBirthDayFieldVisible());
        assertTrue(registerPage.isBirthMonthFieldVisible());
        assertTrue(registerPage.isBirthYearFieldVisible());
    }

    @Then("User checks the email field and 'Reset Password' button are visible")
    public void checkForgotPasswordFieldsVisibility() {
        forgotPasswordPage = pageFactoryManager.getForgotPasswordPage();
        assertTrue(forgotPasswordPage.isEmailFieldVisible());
        assertTrue(forgotPasswordPage.isSendResetPasswordEmailButtonVisible());
    }

    @Then("User checks that search result is not empty")
    public void checkSearchedProductListIsNotEmpty() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertFalse(searchResultPage.isSearchResultByKeywordEmpty());
    }

    @Then("User checks that amount of products in wish list are {string}")
    public void checkAmountOfProductsInWishList(final String expectedAmount) {
        wishListPage = pageFactoryManager.getWishListPage();
        wishListPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishListPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishListPage.getPageTitle());
        assertEquals(expectedAmount, wishListPage.getAmountOfProductsInWishList());
    }

    @Then("User clicks on {string} from the 'Sort' drop-down")
    public void clickSortProductBySortOption(final String sortOrder) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.sortProductListBySortOption(sortOrder);
    }

    @Then("User checks that amount of products in cart is {string}")
    public void checkAmountOfProductsInCartList(final String expectedAmount) {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,productPage.getAddToCartPopup());
        assertEquals(expectedAmount, productPage.getCartProductListCount());
    }

    @Then("User clicks on the {string}")
    public void clickMobileApplication(final String appOption){
        mobileAppsPage.clickMobileApplication(appOption);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
