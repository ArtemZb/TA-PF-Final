package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForNumberWindowsToBe(long timeToWait, int windowsNumber) {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.numberOfWindowsToBe(windowsNumber));
    }

    public List<String> getBrowserWindows() {
        return new ArrayList<String>(driver.getWindowHandles());
    }

    public void switchToWindow(int windowNumber) {
        if (windowNumber >= 0 && windowNumber < getBrowserWindows().size()) {
            driver.switchTo().window(getBrowserWindows().get(windowNumber));
        }
    }

    public String getCurrentWindowURL() {
        return driver.getCurrentUrl();
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
