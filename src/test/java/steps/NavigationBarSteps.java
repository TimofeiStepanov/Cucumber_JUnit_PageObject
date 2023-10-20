package steps;

import org.openqa.selenium.NoSuchElementException;

public class NavigationBarSteps extends BaseStep {

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

    public void SignupLoginLinkClick() {
        navigationBar.getLoginLink().click();
    }




}