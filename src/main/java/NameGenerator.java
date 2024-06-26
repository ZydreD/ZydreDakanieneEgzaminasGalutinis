import org.apache.commons.lang3.RandomStringUtils;

public class NameGenerator {
    public String randomestring() {
        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }
}
