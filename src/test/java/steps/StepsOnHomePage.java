package steps;

public class StepsOnHomePage extends BaseStep{
    public void navigateToHomePage() {


        getDriver().get(getBASE_URL());
    }
}
