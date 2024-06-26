import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({RegistrationPageTest.class, LoginPageTest.class})
public class SuiteTest {
}

