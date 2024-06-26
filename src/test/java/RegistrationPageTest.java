import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPageTest extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    CalculatorPage calculatorPage;

    @Test
    void userCanRegister() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.clickLinkRegister();

        registrationPage.setInputName("BUm12");
        registrationPage.setInputPassword1("Katinukas123");
        registrationPage.setInputPassword2("Katinukas123");
        registrationPage.clickLinkCreate();

        String expectedTitle = "Skaičiuotuvas";
        String actualTitle = calculatorPage.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);

    }
    @Test
    void userCanRegisterNegative() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.clickLinkRegister();

        registrationPage.setInputName("BU");
        registrationPage.setInputPassword1("Katinukas123");
        registrationPage.setInputPassword2("Katinukas123");
        registrationPage.clickLinkCreate();

        String expectedMessage = "Privaloma įvesti nuo 3 iki 32 simbolių";
        String actualMessage = registrationPage.getErrorRegistrationMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);

    }
}
