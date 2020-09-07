package dev.hoteals.web_app_sandbox.Service;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 * Contains methods for testing Continuous Integration, Delivery and Deployment
 */
public class DeploymentService
{
    public static int increment(int x)
    {
        return ++x;
    }

    public static String stringify(int number)
    {
        return Integer.toString(number);
    }
}
