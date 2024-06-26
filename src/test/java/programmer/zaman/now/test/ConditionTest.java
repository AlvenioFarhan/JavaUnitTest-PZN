package programmer.zaman.now.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

@Tag("Integration-Test")
public class ConditionTest {

    @Test
    public void systemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testRunOnlyOnWindows() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void testDisabledOnWindows() {

    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    public void testDisabledOnJava8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testEnabledOnJava8() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnabledOnJava11To15() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testDisabledOnJava11To15() {

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testEnabledOnJavaVendorOracle() {

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testDisabledOnJavaVendorOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisaledOnProfileDev() {

    }

}
