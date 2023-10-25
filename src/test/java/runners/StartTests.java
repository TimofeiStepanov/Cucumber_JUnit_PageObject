package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"/steps"},
        plugin = {"html:cucumber-html-report/cucumber-report.html", "json:cucumber-json-report/cucumber.json", "pretty"},
        snippets = CAMELCASE

)
public class StartTests {

}
