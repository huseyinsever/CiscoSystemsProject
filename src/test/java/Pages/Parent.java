package Pages;

import Utilities.GWD;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Parent {

    public void sendKeysFunction(WebElement element,String value){
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(value);

    }

    public void clickFunction(WebElement element){
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
        GWD.getDriver().switchTo().window(GWD.getDriver().getWindowHandle());
    }

    // sorunlu noktalara scroll yaparken alternatif olarak kullanılabilir. go yaz elemente gitsin, mid yaz elementin sayfa orta gelmesini sağlasın
    public void scrollGoAndMid(WebElement element,String goOrmid) {
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        if(goOrmid.equalsIgnoreCase("go")){
            js.executeScript("arguments[0].scrollIntoView();", element);}
        if(goOrmid.equalsIgnoreCase("mid")) {
            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
            js.executeScript(scrollElementIntoMiddle, element);
        }
    }

    public void verifyContainsText(WebElement element,String text){
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));

    }


    public void visibleElement(WebElement element){
        waitUntilVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }


    public void waitUntilLoading(){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));

    }

    public void waitSectionLoading(){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//mat-tab-body[@role='tabpanel' or @aria-labelledby='mat-tab-label-16-1'])[2]//div")));
    }

    public void waitEditButtonVerify(){
        WebDriverWait wait=new WebDriverWait(GWD.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Active ']")));

    }

}
