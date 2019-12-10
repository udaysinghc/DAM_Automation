package com.intelligencebank.cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features/",
//        features = "src/test/java/com/intelligencebank/features/",
        glue = {"com/intelligencebank/stepDefinitions/"},
        tags = "@DPC",
//        tags = "@runme",
        plugin = {"pretty","json:cucumber_report.json"})
public class DCPTestRunner extends AbstractTestNGCucumberTests {
}
