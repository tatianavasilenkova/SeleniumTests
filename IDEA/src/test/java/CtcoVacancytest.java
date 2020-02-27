import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.PageSetUp;

public class CtcoVacancytest {

    //    private static final By NAV_BAR = By.xpath("//a/span{text()='All vacancies'//..}");

    private WebDriver driver;

    static final By CAREER = By.xpath("//a[contains(@href, 'https://ctco.lv/careers/')]");

    static final By VACANCIES = By.xpath("//a[@href='https://ctco.lv/careers/vacancies/']");

    static final By POSITION = By.xpath("//a[text()='Test Automation Engineer']");

    static final By REQUIRED_SKILL = By.xpath("//h1[text()='Test Automation Engineer']/following-sibling::div/p[3]");

    @Before
    public void setUp() throws InterruptedException {
        new PageSetUp();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyTestAutomationPositionRequirements() {

                Actions builder = new Actions(driver);
                WebDriverWait wait = new WebDriverWait(driver, 10);

                WebElement careersButton = driver.findElement(CAREER);
                careersButton.isDisplayed();
                builder.moveToElement(careersButton).perform();

                WebElement vacanciesButton = driver.findElement(VACANCIES);
                vacanciesButton.isDisplayed();
                builder.moveToElement(vacanciesButton).perform();
                vacanciesButton.click();

                WebElement testEngineerButton = driver.findElement(POSITION);
                wait.until(ExpectedConditions.visibilityOf(testEngineerButton));
                testEngineerButton.click();

                WebElement requiredSkills = driver.findElement(REQUIRED_SKILL);
                wait.until(ExpectedConditions.visibilityOfElementLocated(REQUIRED_SKILL));

                assertThat(requiredSkills.getText(), containsString("Good level in English reading /speaking /writing"));
                assertThat(requiredSkills.getText(), containsString("Team player with good analytical and communication skills"));
                assertThat(requiredSkills.getText(), containsString("Experience with automated testing tools and frameworks"));
    }
}
