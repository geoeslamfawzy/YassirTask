package testSuits.bdd;

import io.cucumber.testng.CucumberOptions;
import testSuits.BaseTest;


@CucumberOptions(
        features = {"src/test/java/testSuits/bdd/features/contactUs.feature"},
        glue = {},
        plugin = {"html:test-output/cucumber_reports/data.html"}
)

public class Runner extends BaseTest {

}
