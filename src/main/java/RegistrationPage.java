import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//*[@id='username']")
    private WebElement inputName;
    @FindBy(css = "#password")
    private WebElement inputPassword1;
    @FindBy(css = "#passwordConfirm")
    private WebElement inputPassword2;
    @FindBy(xpath = "//*[@id='userForm']/button")
    private WebElement linkIntoCreatedAccount;
    @FindBy(xpath = "//*[@id='username.errors']")
    private WebElement errorRegistrationMessage;
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void setInputName(String name) {
        inputName.sendKeys(name);
    }

    public void setInputPassword1(String password1) {
        inputPassword1.sendKeys(password1);
    }

    public void setInputPassword2(String password2) {
        inputPassword2.sendKeys(password2);

    }

    public void clickLinkCreate() {
        linkIntoCreatedAccount.click();
    }

    public String getErrorRegistrationMessage() {
        return errorRegistrationMessage.getText();
    }
}
