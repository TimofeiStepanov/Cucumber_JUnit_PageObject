package steps;

public class HomePageSteps extends BaseStep{
    public void navigateToHomePage() {


        getDriver().get(getBASE_URL());
    }
}
