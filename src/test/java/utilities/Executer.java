package utilities;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features ={"src/test/resources/Features/TurkHavaYollari.feature"},
        glue = {"tests"},
        monochrome = true,
        plugin = {"pretty","html:/HtmlReports"}

)

public class Executer {
}
