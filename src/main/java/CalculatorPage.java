import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalculatorPage extends BasePage {
    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']/a")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[@class='navbar-brand']")
    private WebElement title;

    @FindBy(xpath = "//*[@id='sk1']")
    private WebElement number1;
    @FindBy(xpath = "//*[@id='sk2']")
    private WebElement number2;
    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement operation;
    @FindBy(xpath = "//input[@value='skaičiuoti']")
    private WebElement calculate;
    @FindBy(xpath = "//span[contains(@id, '.errors')]")
    private List<WebElement> errors;
    @FindBy(xpath = "//a[contains(@href, 'skaiciai')]")
    private WebElement operationsPageButton;


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkLogout() {
        logoutButton.click();
    }

    public String getTitle() {
        return title.getText();
    }

    public void setNumber1(String number1) {
        this.number1.click();
        this.number1.clear();
        this.number1.sendKeys(number1);
    }

    public void setNumber2(String number2) {
        this.number2.click();
        this.number1.clear();
        this.number2.sendKeys(number2);
    }

    public void setOperation(String operation) {
        Select select = new Select(this.operation);
        select.selectByValue(operation);
    }

    public void calculate() {
        calculate.click();
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void clickLinkOperations() {
        operationsPageButton.click();
    }
}
