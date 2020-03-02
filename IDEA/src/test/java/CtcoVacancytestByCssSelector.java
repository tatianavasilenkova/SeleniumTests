import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.PageSetUp;

public class CtcoVacancytestByCssSelector {

        private WebDriver driver;

        static final By CAREER = By.cssSelector("#menu-item-127");

        static final By VACANCIES = By.cssSelector("#menu-item-131 > .reload-page");

        static final By POSITION = By.cssSelector("#menu-item-3249 > .menu-link");

        static final By PAGE_TITLE = By.cssSelector(".animated .active h1");

        //.animated .active > .text-block >div>p:nth-child(3)
        //.animated > .text-block p:nth-child(3)
        //.active .text-block p:nth-child(3)
        static final By REQUIRED_SKILL = By.cssSelector(".active .text-block p:nth-child(3)");



        @Before
        public void setUp() throws InterruptedException {
            driver = new PageSetUp().getDriver();
        }

        @After
        public void tearDown() {
            driver.quit();
        }

        @Test
        public void verifyTestAutomationPositionRequirements() {

            Actions builder = new Actions(driver);
            new WebDriverWait(driver, 10);

            // open career menu
            WebElement careersButton = driver.findElement(CAREER);
            careersButton.isDisplayed();
            builder.moveToElement(careersButton).perform();

            // Open vacancies list
            WebElement vacanciesButton = driver.findElement(VACANCIES);
            vacanciesButton.isDisplayed();
            builder.moveToElement(vacanciesButton);
            vacanciesButton.click();

            // select "Test Automation Engineer" position
            getElement(driver, POSITION).click();

            // Assert Page elements:
            String currentPageTitle = getElement(driver, PAGE_TITLE).getText();
            assertThat("Incorrect page title", currentPageTitle, equalTo("Test Automation Engineer"));

            String requiredSkillsText = driver.findElement(REQUIRED_SKILL).getText();
            assertThat("Language required skills text not found", requiredSkillsText, containsString("Good level in English reading /speaking /writing"));
            assertThat("Communication required skills text not found", requiredSkillsText, containsString("Team player with good analytical and communication skills"));
            assertThat("Testing tools required skills text not found", requiredSkillsText, containsString("Experience with automated testing tools and frameworks"));
        }

    private WebElement getElement(WebDriver driver, By locator) {
        // posledujasaja zapisj ravna:   WebElement element = driver.findElement();
        WebElement element = new WebDriverWait(driver, 5)
                .pollingEvery(Duration.ofSeconds(1)) //povtorjatj kazdije 1 sec
                .ignoring(StaleElementReferenceException.class)  // ignorim osibku esli vilezet (naprimer esli izmenilasj DOM modelj)
                .withMessage("element not found")
                .until(ExpectedConditions.presenceOfElementLocated(locator));  // etot veit nuzen v slu4aje esli mi znajem 4to element
        // to4no budet 4erez 'n' minut
        return element;
    }
}
