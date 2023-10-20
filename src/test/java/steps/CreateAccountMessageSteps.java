package steps;

public class CreateAccountMessageSteps extends BaseStep{

    public String accountCreatedMessage() {
        return createAccountMessage.getAccCreateH2Text().getText();
    }
    public void accCreateConfirm(){
        createAccountMessage.getContinueButton().click();
        String url = getDriver().getCurrentUrl();
        if(url.equals("https://automationexercise.com/account_created#google_vignette")){
            getDriver().navigate().refresh();
            createAccountMessage.getContinueButton().click();
        }

    }

}
