package przyklad1;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/my-store.feature",
        plugin = {"pretty","html:out"})

public class MyStoreTest {
}