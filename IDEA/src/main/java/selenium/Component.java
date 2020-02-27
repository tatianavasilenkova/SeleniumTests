package selenium;

import org.openqa.selenium.WebElement;

public class Component {

    protected final WebElement element;

    protected TestContext context;

    protected Component(WebElement element, TestContext context) {
        this.element = element;
        this.context = context;
    }

    public WebElement getElement() {
        return element;
    }

    public String getText() {
        return getElement().getText();
    }

    public void click() {
        getElement().click();
    }
}
