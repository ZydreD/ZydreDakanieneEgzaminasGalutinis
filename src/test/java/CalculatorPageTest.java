import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorPageTest extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;
    CalculatorPage calculatorPage;


    @Test
    void calculatorPositiveTest() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputName("BUm1");
        loginPage.setInputPassword("Katinukas123");
        loginPage.login();
        assertThat(calculatorPage.getTitle()).isEqualTo("Skaičiuotuvas");

        calculatorPage.setNumber1("10");
        calculatorPage.setNumber2("15");
        calculatorPage.setOperation("+");
        calculatorPage.calculate();
        assertEquals("Skaičiuoti", driver.getTitle());

    }
    @Test
    void calculatorNegativeTest() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputName("BUm1");
        loginPage.setInputPassword("Katinukas123");
        loginPage.login();
        assertThat(calculatorPage.getTitle()).isEqualTo("Skaičiuotuvas");

        calculatorPage.setNumber1("-10");
        calculatorPage.setNumber2("0");
        calculatorPage.setOperation("/");
        calculatorPage.calculate();
        assertThat(calculatorPage.hasErrors()).isTrue();

    }
    @Test
    void calculatorOperationsPositiveTest() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        //Navigate to Operations Table
        loginPage.setInputName("BUm1");
        loginPage.setInputPassword("Katinukas123");
        loginPage.login();
        calculatorPage.clickLinkOperations();


//        calculatorPage.setNumber1("10");
//        calculatorPage.setNumber2("0");
//        calculatorPage.setOperation("/");
//        calculatorPage.calculate();
//        assertThat(calculatorPage.hasErrors()).isTrue();

    }
    @Test
    void userCanLogout() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);


        loginPage.setInputName("BUm");
        loginPage.setInputPassword("Katinukas123");
        loginPage.login();

        calculatorPage.clickLinkLogout();
        assertThat(loginPage.getTitle()).isEqualTo("Internetinis skaičiuotuvas");
    }

}
