package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/account_management_smoke_test.feature",
        glue = {"/steps"},
        plugin = {"html:cucumber-html-report/cucumber-report.html", "json:cucumber-json-report/cucumber.json", "pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class StartTests {

}
