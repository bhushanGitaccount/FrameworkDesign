import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import pageobjects.GoibiboRepo;
import step_definitions.BaseClass;

public class GoibiboWeekendTicketBooking extends BaseClass
{

    @Then("^choose weekend dates$")
    public void chooseWeekEndDates()
    {
        GoibiboRepo obj = new GoibiboRepo();
        obj.SelectDate();



    }
}
