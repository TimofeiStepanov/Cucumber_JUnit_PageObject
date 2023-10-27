package steps;

public class StepsOnSignupPage extends BaseStep{

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
    }

    public void monthOfBirthSelect(String dateOfBirth) {
        String[] splitedDateOfBirth = dateOfBirth.split("[.]");
        signupPage.getMonthsOfBirth().sendKeys(splitedDateOfBirth[1]);
    }

    public void yearOfBirthSelect(String dateOfBirth) {
        String[] splitedDateOfBirth = dateOfBirth.split("[.]");
        signupPage.getYearOfBirth().sendKeys(splitedDateOfBirth[2]);
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

    public void createAccountButtonClick() {
        signupPage.getCreateAccountButton().submit();
    }
}
