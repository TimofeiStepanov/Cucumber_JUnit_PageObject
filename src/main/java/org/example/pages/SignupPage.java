package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    final WebDriver driver;

    private static final String BASE_URL = "https://automationexercise.com/signup";
    @FindBy(xpath = "//h2/b[text()='Enter Account Information']")
    WebElement accountInformationForm;
    @FindBy(xpath = "//*[@id='id_gender1']")
    private static WebElement genderMrCheckBox;
    @FindBy(xpath = "//*[@id='password']")
    private static WebElement passwdInputField;
    @FindBy(id = "days" )
    private static WebElement dayOfBirth;
    @FindBy(id = "months")
    private static WebElement monthOfBirth;
    @FindBy(id = "years")
    private static WebElement yearOfBirth;

//    @FindBy(xpath = "//*[@id='uniform-days']")
//    WebElement daysDDlist;
//    @FindBy(xpath = "//*[@id='days']/option[11]")
//    WebElement dayValue;
//    @FindBy(xpath = "//*[@id='uniform-months']")
//    WebElement monthsDDlist;
//    @FindBy(xpath = "//*[@id='months']/option[6]")
//    WebElement monthValue;
//    @FindBy(xpath = "//*[@id='years']")
//    WebElement yearsDDlist;
//    @FindBy(xpath = "//*[@id='years']/option[68]")
//    WebElement yearValue;
    @FindBy(xpath = "//*[@id='newsletter']")
    private static WebElement newsletterCheckBox;
    @FindBy(xpath = "//*[@id='optin']")
    private static WebElement offerCheckBox;
    @FindBy(xpath = "//*[@id='first_name']")
    private static WebElement first_nameInputField;
    private static @FindBy(xpath = "//*[@id='last_name']")
    WebElement last_nameInputField;
    @FindBy(xpath = "//*[@id='address1']")
    private static WebElement address1InputField;
    @FindBy(id = "country")
    WebElement counrtyInputField;
    @FindBy(xpath = "//*[@id='country']")
    private static WebElement countryDDlist;
    private static @FindBy(xpath = "//*[@id='country']/option[2]")
    WebElement countryValue;
    private static @FindBy(xpath = "//*[@data-qa='state']")
    WebElement stateInputField;
    private static @FindBy(xpath = "//*[@id='city']")
    WebElement citiInputField;
    private static @FindBy(xpath = "//*[@id='zipcode']")
    WebElement zipcodeInputField;
    private static @FindBy(xpath = "//*[@id='mobile_number']")
    WebElement phoneInputField;
    private static @FindBy(xpath = "//*[@data-qa='create-account']")
    WebElement createAccountButton;
    private static @FindBy(xpath = "//*[@data-qa='name'")
    WebElement userName;



    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getGenderMrCheckBox() {
        return genderMrCheckBox;
    }

    public  WebElement getPasswdInputField() {
        return passwdInputField;
    }
    public WebElement getDayOfBirth() {
        return dayOfBirth;
    }
    public WebElement getMonthsOfBirth() {
        return monthOfBirth;
    }
    public WebElement getYearOfBirth() {
        return yearOfBirth;
    }
    public WebElement getNewsletterCheckBox() {
        return newsletterCheckBox;
    }

    public WebElement getOfferCheckBox() {
        return offerCheckBox;
    }
    public WebElement getFirst_nameInputField() {
        return first_nameInputField;
    }

    public WebElement getLast_nameInputField() {
        return last_nameInputField;
    }

    public WebElement getAddress1InputField() {
        return address1InputField;
    }

    public  WebElement getCounrtyInputField() {
        return counrtyInputField ;
    }

    public WebElement getStateInputField() {
        return stateInputField;
    }

    public WebElement getCitiInputField() {
        return citiInputField;
    }

    public WebElement getZipcodeInputField() {
        return zipcodeInputField;
    }

    public WebElement getPhoneInputField() {
        return phoneInputField;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }

    public String getBaseUrl(){
        return BASE_URL;
    }

}
