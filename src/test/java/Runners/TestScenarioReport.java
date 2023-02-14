package Runners;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@CucumberOptions(
            features = {"src/test/java/FeatureFiles/Cisco.feature"},
            glue = {"StepDefinitions"}

)
@Listeners({ExtentITestListenerClassAdapter.class})
public class TestScenarioReport extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser){
        GWD.threadBrowserName.set(browser);
    }

    @AfterClass
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("User Name", "Hüseyin SEVER ");
        ExtentService.getInstance().setSystemInfo("Application Name", "Cisco Systems");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
    }

}
