package Cucumber.Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Cucumber/Features",
        glue = "Cucumber/StepDefinitions",
        plugin = {"pretty"},
        tags = "@default"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
