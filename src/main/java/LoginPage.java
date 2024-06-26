import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href, 'registruoti')]")
    private WebElement registrationButton;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[text()='Prisijungti']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class='form-group has-error']/span[2]")
    private WebElement errorLoginMessage;
    @FindBy(xpath = "//h1[@class='text-center']")
    private WebElement title;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkRegister() {
        registrationButton.click();
    }

    public void setInputName(String name) {
        inputName.sendKeys(name);
    }
    public void setInputPassword(String name) {
        inputPassword.sendKeys(name);
    }
    public void login() {
        loginButton.click();
    }

    public String getErrorLoginMessage() {
        return errorLoginMessage.getText();
    }

    public String getTitle() {
        return title.getText();}
}
