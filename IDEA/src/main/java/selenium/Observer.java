package selenium;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Observer {

    protected TestContext context;

    protected TestContext getContext() {
        return context;
    }

    public Observer(TestContext context) {
        this.context = context;
    }

    public boolean isElementPresent(By by) {
        try {
            context.getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(By by) {
        return context.getDriver().findElement(by).isDisplayed();
    }

    public boolean isElementVisible(By by) {
        try {
            return isElementPresent(by) && isElementDisplayed(by);
        } catch (WebDriverException e) {
            return false;
        }
    }

    protected FluentWait<WebDriver> getWait() {
        return getContext().getWait(2);
    }

    public WebElement findElement(By by) {
        return context.getWait(2).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(By by) {
        return getWait().until(presenceOfElementLocated(by));
    }

}
