package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.GWD;
import com.sun.source.tree.AssertTree;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Cisco_StepDefinitions {
    DialogContent dc=new DialogContent();
    Parent parent=new Parent();
    @Given("Navigate to Cisco Website")
    public void navigateToCiscoWebsite() {
        GWD.getDriver().get("https://www.cisco.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Login to the app with your account")
    public void loginToTheAppWithYourAccount() {
        dc.findAndClick("loginButton");
        dc.findAndSend("eMail","huseyin.sever@outlook.com.tr");
        dc.findAndClick("entryButton");
        dc.findAndClick("closeButton");

        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(dc.inputPassword));

        JavascriptExecutor js= (JavascriptExecutor)GWD.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        dc.findAndSend("password","Husnu3535!");
        dc.findAndClick("signInButton");
    }

    @When("Verify that you are logged into your account")
    public void verifyThatYouAreLoggedIntoYourAccount() {
        dc.verifyText("loginVerify","umut e.");
    }

    @When("Verify menu options")
    public void verifyMenuOptions() {
        List<String> expectedList=new ArrayList<>();
        expectedList.add("Products and Services");
        expectedList.add("Solutions");
        expectedList.add("Support");
        expectedList.add("Learn");

        for (int i = 0; i < expectedList.size(); i++) {
            Assert.assertEquals(expectedList.get(i),dc.menuOptionsVerify.get(i).getText());
        }


    }

    @When("Click on Solutions")
    public void clickOnSolutions() {
        dc.findAndClick("solutionsButton");
    }

    @When("Click on By Technology")
    public void clickOnByTechnology() {
        dc.findAndClick("byTechnologyButton");
    }

    @When("Click on Artificial Intellingence")
    public void clickOnArtificialIntellingence() {
        dc.findAndClick("AI_Button");
    }

    @When("Click the video button")
    public void clickTheVideoButton() {
        dc.findAndClick("videoButton");
    }

    @When("Wait for the video to end and close the video")
    public void waitForTheVideoToEndAndCloseTheVideo() {
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.attributeContains(dc.videoLocater,"aria-valuetext","2:23 of 2:23"));
        dc.findAndClick("videoCloseButton");
    }

    @When("Click on all of the other menu options and verify they are")
    public void clickOnAllOfTheOtherMenuOptionsAndVerifyTheyAre() {
        dc.findAndClick("benefits");
        dc.findAndClick("solutions");
        dc.findAndClick("whyCisco");
        dc.findAndClick("whatsNew");
        dc.findAndClick("resources");

        List<String>expectedList=new ArrayList<>();
        expectedList.add("Benefits");
        expectedList.add("Solutions");
        expectedList.add("Why Cisco");
        expectedList.add("What's New");
        expectedList.add("Resources");

        for (int i = 0; i < expectedList.size(); i++) {
                Assert.assertEquals(expectedList.get(i),dc.getMenuOptionsVerify.get(i).getText());
        }
        JavascriptExecutor js= (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

    }

    @And("Log out of your account and verify the text that appears")
    public void logOutOfYourAccountAndVerifyTheTextThatAppears() {
        GWD.getDriver().get("https://www.cisco.com/site/us/en/index.html");
        dc.findAndClick("umut_eButton");
        dc.findAndClick("logOut");
        dc.verifyText("messageVerify","Thank you for visiting.");
    }

    @Then("Go back to home page and verify")
    public void goBackToHomePageAndVerify() {
        dc.findAndClick("returnWebSite");
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlContains("https://www.cisco.com/"));
    }
}