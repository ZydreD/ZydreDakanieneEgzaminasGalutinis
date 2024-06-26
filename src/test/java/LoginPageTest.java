import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest extends BaseTest{
    LoginPage loginPage;
    RegistrationPage registrationPage;
    CalculatorPage calculatorPage;

    @Test
    void userCanRegister() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputName("BUm");
        loginPage.setInputPassword("Katinukas123");
        loginPage.login();

        String expectedTitle = "Skaičiuotuvas";
        String actualTitle = calculatorPage.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);

    }
    @Test
    void userCanRegisterNegative() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputName("BU");
        loginPage.setInputPassword("Katinukas123");
        loginPage.login();

        String expectedMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualMessage = loginPage.getErrorLoginMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);

    }
}
