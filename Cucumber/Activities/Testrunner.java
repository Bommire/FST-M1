package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"Stepdefintion"},
    tags = "@Activity3",
    publish=true,
    plugin= {
    		"pretty",
    		"html:src/reports/HTML_Report.html",
    		"Json:src/reports/Json_Report.json",
    		"Junit:src/reports/Xml_Report.xml",
    }
)

public class Testrunner {

}
