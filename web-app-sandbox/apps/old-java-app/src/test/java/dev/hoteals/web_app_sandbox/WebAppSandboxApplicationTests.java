package dev.hoteals.web_app_sandbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebAppSandboxApplicationTests
{
    @Test
    @DisplayName("Environment variables exist")
    void envVariableExistTest()
    {
        assertNotNull(System.getenv("WEBSANDBOX_JDBC_URL"));
    }

    @Autowired
    private Environment env;

    @Test
    @DisplayName("Properties file loads the env variables")
    void propertyVariableLoadTest()
    {
        assertNotNull(env.getProperty("WEBSANDBOX_JDBC_URL"));
    }
}
