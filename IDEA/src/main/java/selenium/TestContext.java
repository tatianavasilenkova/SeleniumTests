package selenium;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.NoSuchElementException;
import java.util.Observer;
//import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {

    private static final By SEARCH_FIELD = By.cssSelector("[selenium-id='search_products_text_field']");

    private WebDriver driver;

//    private long implicitWait;

    private Observer observer;

    public TestContext() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Observer getObserver() {
        return observer;
    }

    public WebDriverWait getWait(int t) {
        return new WebDriverWait(driver, t);
    }


//    private void waitSearchField() {
//
//        // Waiting 30 seconds for an element to be present on the page, checking
//        // for its presence once every 5 seconds.
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(30, SECONDS)
//                .pollingEvery(5, SECONDS)
//                .ignoring(NoSuchElementException.class);
//
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//
//            public WebElement apply(WebDriver driver) {
//                return driver.findElement(SEARCH_FIELD);
//            }
//        });
//    }
}
