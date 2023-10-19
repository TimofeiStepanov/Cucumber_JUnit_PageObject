package tests;


import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;


public class CreateAccountSteps extends BaseStep {

    private String nickName;
    public void navigateToHomePage() {
        getDriver().get(getBASE_URL());
    }

    public String HomeLincColor() {
        return navigationBar.getHomeLink().getAttribute("style");
    }

    public Boolean loginLinkIsDisplayed() {
        return navigationBar.getLoginLink().isDisplayed();
    }

    public Boolean loggedLinkIsDisplayed() throws NoSuchElementException {
        try {
            return navigationBar.getLoggedLink().isDisplayed();
        } catch (Exception e) {
            //TODO : Add log message
            return false;
        }
    }

    public Boolean signupFormIsDisplayed() throws NoSuchElementException {
        try {
            return loginPage.getSignupForm().isDisplayed();

        } catch (Exception e) {
            // TODO : Add log message
            return false;
        }

    }

    public Boolean nameFieldInSignupFormIsDisplayed() throws NoSuchElementException {
        try {
            return loginPage.getNameInputSignupField().isDisplayed();
        } catch (Exception e) {
            // TODO : Add log message
            return false;
        }
    }

    public Boolean emailFieldInSignupFormIsDisplayed() throws NoSuchElementException {
        try {
            return loginPage.getEmailSignupInputField().isDisplayed();
        } catch (Exception e) {
            // TODO : Add log message
            return false;
        }
    }

    public void inputNickName(String nickName) {
        loginPage.getNameInputSignupField().click();
        loginPage.getNameInputSignupField().sendKeys(nickName);
    }
    public String inputtedName() {

        return loginPage.getNameInputSignupField().getAttribute("value");
    }

    public void inputEmail(String email) {
        loginPage.getEmailSignupInputField().click();
        loginPage.getEmailSignupInputField().sendKeys(email);
    }

   public String inputtedEmail() {
        return loginPage.getEmailSignupInputField().getAttribute("value");
   }



    public Boolean signupButtonIsDisplayed() throws NoSuchElementException {
        try {
            return loginPage.getSignupButton().isDisplayed();
        }catch (Exception e) {
            // TODO : Add log message
            return false;
        }
    }
    public void mrRadioButtonSelect() {
        signupPage.getGenderMrCheckBox().click();
    }

    public void nameAccountInformationFieldTest() {
    }

    public void emailAccountInformationFieldTest() {

    }

    public void passwordInput(String password) {
        signupPage.getPasswdInputField().sendKeys(password);
    }

    public void dayOfBirthSelect(String dateOfBirth) {
        String[] splitedDateOfBirth = dateOfBirth.split("[.]");
        signupPage.getDayOfBirth().sendKeys(splitedDateOfBirth[0]);
        System.out.println(splitedDateOfBirth[0]);
    }

    public void monthOfBirthSelect(String dateOfBirth) {
        String[] splitedDateOfBirth = dateOfBirth.split("[.]");
        signupPage.getMonthsOfBirth().sendKeys(splitedDateOfBirth[1]);
        System.out.println(splitedDateOfBirth[1]);
    }

    public void yearOfBirthSelect(String dateOfBirth) {
        String[] splitedDateOfBirth = dateOfBirth.split("[.]");
        signupPage.getYearOfBirth().sendKeys(splitedDateOfBirth[2]);
        System.out.println(splitedDateOfBirth[2]);
    }



    public void checkBoxSignUpForOurNewsletterComfirm() {
        signupPage.getNewsletterCheckBox().click();
    }

    public void checkBoxReceiveSpecialOffersFromOurPartnersConfirm() {
        signupPage.getOfferCheckBox().click();
    }

    public void firstNameInput(String firstName) {
        signupPage.getFirst_nameInputField().sendKeys(firstName);
    }

    public void lastNameInput(String lastName) {
        signupPage.getLast_nameInputField().sendKeys(lastName);
    }

    public void addressInput(String address) {
        signupPage.getAddress1InputField().sendKeys(address);
    }

    public void countrySelect(String country) {
        signupPage.getCounrtyInputField().sendKeys(country);
    }

    public void stateInput(String state) {
        signupPage.getStateInputField().sendKeys(state);
    }

    public void cityInput(String city) {
        signupPage.getCitiInputField().sendKeys(city);
    }

    public void zipcodeInput(Integer zipcode) {
        signupPage.getZipcodeInputField().sendKeys(Integer.toString(zipcode));
    }

    public void phoneInput(String phone) {
        signupPage.getPhoneInputField().sendKeys(phone);
    }


    public void createAccountMessageTest() {
        Assertions.assertEquals(createAccountMessage.accCreateMessageTextGet(), "ACCOUNT CREATED!");
    }

    public void confirmButtonAccountCreatedMessageTest() {
        createAccountMessage.accCreateConfirm();
    }

    public void returnToHomePageTest() {
        Assertions.assertEquals(getDriver().getCurrentUrl(), getBASE_URL());
    }

    public void loggedNameInNavBarTest() {
//        Assertions.assertEquals(navigationBar.loggedNameGet(),inputtedName());
    }


    public void driverStop() {
        getDriver().quit();
    }
}
