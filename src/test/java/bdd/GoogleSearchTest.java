package bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/Cucumber/Features/google-text-search.feature",
        plugin = {"pretty","html:out"}
)
public class GoogleSearchTest {

    @BeforeClass
    public static void setUp() {
        System.out.println("setUp()");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("tearDown()");
    }
}
