package selenium;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class PageSetUp {

    private WebDriver driver;

    private static final By PAGE_ELEMENT = By.xpath("//a[@href='https://ctco.lv/careers/vacancies/']");

    public PageSetUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\SRDEV\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://ctco.lv/");
        waitPageElement(driver);
//        driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }

    private void waitPageElement(WebDriver driver) {

        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(PAGE_ELEMENT);
            }
        });
    }

}

