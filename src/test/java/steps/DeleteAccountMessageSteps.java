package steps;

public class DeleteAccountMessageSteps extends BaseStep {

    public void deleteAccountConfirm() {
        deleteAccountMessage.getContinueButton().click();
        String url = getDriver().getCurrentUrl();
        if (url.equals("https://automationexercise.com/delete_account#google_vignette")) {
            getDriver().navigate().refresh();
            deleteAccountMessage.getContinueButton().click();
        }
    }

    public String accountDeletedMessage() {
        return deleteAccountMessage.getAccountDeleteMessage().getText();
    }

}
