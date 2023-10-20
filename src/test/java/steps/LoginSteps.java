package steps;

public class LoginSteps extends BaseStep {
    public void emailInputLoginFormTest(String email) {
        loginPage.emailLoginInputField(email);
    }

    public void passwdInputLoginFormTest(String password) {
        loginPage.PasswdLLoginInputField(password);
    }

//

}
