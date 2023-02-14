package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DialogContent extends Parent{
    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Log in'])[2]")
    private WebElement loginButton;

    @FindBy(css = "input[id='userInput']")
    private WebElement eMail;

    @FindBy(css = "input[name='login-button']")
    private WebElement entryButton;

    @FindBy(css = "div[id='onetrust-close-btn-container']>button")
    private WebElement closeButton;

    @FindBy(css = "span[data-se='o-form-input-password']")
    public WebElement inputPassword;

    @FindBy(css = "input[type='password']")
    public WebElement password;

    @FindBy(css = "input[class='button button-primary']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='umut e.']")
    private WebElement loginVerify;

    @FindBy(xpath = "(//div[@data-c-version='REI:Accordion (TO BE DEPRECATED):V0.0.0'])[1]//div[contains(@class,'cmp-accordion__item')]")
    public List <WebElement> menuOptionsVerify;

    @FindBy(css = "button[data-text='Solutions']")
    private WebElement solutionsButton;

    @FindBy(css = "li[aria-controls='tabs-9cfa4a460b-item-8621ec0552-tabpanel']")
    private WebElement byTechnologyButton;

    @FindBy(css = "a[href='https://www.cisco.com/c/en/us/solutions/artificial-intelligence.html']")
    private WebElement AI_Button;

    @FindBy(css = "a[class='dmc-button atlantic pal-6 c2c-proactive-dismiss']")
    private WebElement chatCloseButton;

    @FindBy(css = "a[class='cta pri0 icon play']")
    private WebElement videoButton;

    @FindBy(css = "button[class='close-button']>svg")
    private WebElement videoCloseButton;

    @FindBy(xpath = "//div[@class='vjs-progress-holder vjs-slider vjs-slider-horizontal']")
    public WebElement videoLocater;

    @FindBy(css = "a[href='#benefits']")
    private WebElement benefits;

    @FindBy(css = "a[href='#solutions']")
    private WebElement solutions;

    @FindBy(css = "a[href='#why-cisco']")
    private WebElement whyCisco;

    @FindBy(css = "a[href='#whats-new']")
    private WebElement whatsNew;

    @FindBy(css = "a[href='#resources']")
    private WebElement resources;

    @FindBy(xpath = "//ul[contains(@style,'width:')]//li")
    public List <WebElement> getMenuOptionsVerify;

    @FindBy(xpath = "//a[@class='fw-c-header__logo']")
    private WebElement ciscoImageClick;

    @FindBy(xpath = "//span[text()='umut e.']")
    private WebElement umut_eButton;

    @FindBy(css = "a[id='button-ee3a97e50a']>span")
    private WebElement logOut;

    @FindBy(css = "p[class='title']")
    private WebElement messageVerify;

    @FindBy(css = "a[href='//www.cisco.com/']")
    private WebElement returnWebSite;













    WebElement myElement;

    public void findAndClick(String element){
        switch (element){
            case "loginButton":myElement=loginButton;break;
            case "entryButton":myElement=entryButton;break;
            case "signInButton":myElement=signInButton;break;
            case "closeButton":myElement=closeButton;break;
            case "solutionsButton":myElement=solutionsButton;break;
            case "byTechnologyButton":myElement=byTechnologyButton;break;
            case "AI_Button":myElement=AI_Button;break;
            case "videoButton":myElement=videoButton;break;
            case "videoCloseButton":myElement=videoCloseButton;break;
            case "benefits":myElement=benefits;break;
            case "solutions":myElement=solutions;break;
            case "whyCisco":myElement=whyCisco;break;
            case "whatsNew":myElement=whatsNew;break;
            case "resources":myElement=resources;break;
            case "ciscoImageClick":myElement=ciscoImageClick;break;
            case "umut_eButton":myElement=umut_eButton;break;
            case "logOut":myElement=logOut;break;
            case "returnWebSite":myElement=returnWebSite;break;






        }
        clickFunction(myElement);
    }

    public void findAndSend(String element, String value){
        switch (element){
            case "eMail":myElement=eMail;break;
            case "password":myElement=password;break;





        }
        sendKeysFunction(myElement,value);
    }

    public void verifyText(String element, String text){
        switch (element){
            case "loginVerify":myElement=loginVerify;break;
            case "messageVerify":myElement=messageVerify;break;



        }
        verifyContainsText(myElement,text);
    }
























}
