package steps;

import org.openqa.selenium.NoSuchElementException;

public class StepsOnNavigationBar extends BaseStep {

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

    public String loggedName() {
        return navigationBar.getLoggedName().getText();
    }

    public void signupLoginLinkClick() {
        navigationBar.getLoginLink().click();
    }
    public void logoutLinkClick() {
        navigationBar.getLogoutLink().click();
    }
    public String signupLoginLinkColor() {
        return navigationBar.getLoginLink().getAttribute("style");
    }
    public void deleteAccountLinkClick() {
        navigationBar.getDeleteAccountLink().click();
        String url = getDriver().getCurrentUrl();
        if (url.equals("https://automationexercise.com/#google_vignette")) {
            getDriver().get("https://automationexercise.com/delete_account");
        }
    }


}