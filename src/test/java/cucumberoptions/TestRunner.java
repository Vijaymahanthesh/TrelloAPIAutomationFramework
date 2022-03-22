package cucumberoptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/login.feature",plugin="json:target/jsonReports/cucumber-reports.json", glue="stepDefinations",tags="@createBoard")
//tags="@createBoard
public class TestRunner {

		

}
