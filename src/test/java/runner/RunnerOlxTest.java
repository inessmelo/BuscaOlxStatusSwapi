package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\features\\olx.feature",
		glue = "steps",
		snippets = SnippetType.CAMELCASE,
		tags = "@buscar",
		plugin = {"pretty", "json:target/reports/CucumberReports.json"},
		monochrome = true
		)
public class RunnerOlxTest {

	
}
