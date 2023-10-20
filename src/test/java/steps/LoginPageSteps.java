package steps;

import org.openqa.selenium.NoSuchElementException;

public class LoginPageSteps extends BaseStep {
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
        } catch (Exception e) {
            // TODO : Add log message
            return false;
        }
    }
    public void signupButtonClick() {
        loginPage.getSignupButton().click();
    }

}
