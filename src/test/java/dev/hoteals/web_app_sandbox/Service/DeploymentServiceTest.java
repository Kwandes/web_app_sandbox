package dev.hoteals.web_app_sandbox.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DeploymentServiceTest
{

    @Test
    void incrementTest()
    {
        assertEquals(DeploymentService.increment(1), 2);
    }

    private static Stream<Arguments> stringifyArguments()
    {
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(0, "0"),
                Arguments.of(-1, "-1")
        );
    }

    @ParameterizedTest
    @MethodSource("stringifyArguments")
    void stringifyTest(int number, String expected)
    {
        assertEquals(DeploymentService.stringify(number), expected);
    }


    private static Stream<Arguments> parseToIntArguments()
    {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("0", 0),
                Arguments.of("-1", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("parseToIntArguments")
    void parseToInt(String text, int expected)
    {
        assertEquals(DeploymentService.parseToInt(text), expected);
    }
}