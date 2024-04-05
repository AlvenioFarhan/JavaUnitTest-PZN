package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testRunOnlyOnWindows(){

    }
    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void testDisabledOnWindows(){

    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    public void testDisabledOnJava8(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testEnabledOnJava8(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnabledOnJava11To15(){

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testDisabledOnJava11To15(){

    }

}
