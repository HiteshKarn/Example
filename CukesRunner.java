import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

         features = {"src/test/resources/Example.feature"}
        , glue = {"com.example"}
        , monochrome = true
        , plugin = {"pretty", "html:target/cucumber_html_report",
        "json:target/cucumber.json",
        "junit:target/cucumber.xml"}
     //   ,tags = {"@Scenario2"}

)
public class CukesRunner
{

}