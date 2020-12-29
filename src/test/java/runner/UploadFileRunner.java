package runner;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/uploadFile.feature",
        tags = {"@UploadFile"},
        glue = "stepdefinition"

)
public class UploadFileRunner {
}
