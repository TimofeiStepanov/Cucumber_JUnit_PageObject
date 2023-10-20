package steps;


import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;


public class CreateAccountSteps extends BaseStep {






















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



}
