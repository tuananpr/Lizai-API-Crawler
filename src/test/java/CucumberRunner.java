
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features/"},
        //publish = true,
        //features = {"."},
        monochrome = true,
        strict = true,
        glue = {"stepdefinition","src/main/java/stepdefinition/"},
        tags = "@login-01",
        plugin = {"html:target/result",
                "pretty",
                "json:target/test-classes/reports/result.json"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
