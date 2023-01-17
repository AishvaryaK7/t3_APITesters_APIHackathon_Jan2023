package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"stepDefinitions_Batch_Module","stepDefinitions_Program_Module"},
        monochrome = true,
        dryRun = false,
        plugin = { "pretty","html:target/html-reports/report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",             
                
                }
        
)

public class testRunner 
{

}
