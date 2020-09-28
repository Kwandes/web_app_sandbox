package dev.hoteals.web_app_sandbox.functional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTests
{
    // These 2 tests are not supposed to run as part of normal CI and `mvn` test due to being excluded in the pom.xml
    // in order to run them, you must use `mvn -Dtest=dev.hoteals.web_app_sandbox.functional.** test`
    @Test
    public void validTest()
    {
        assertThat(true).isEqualTo(true);
    }

    @Test
    public void invalidTest()
    {
        assertThat(true).isEqualTo(false);
    }
}
