package StepDef;

import Base.Utils;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepdefs extends Utils {

    Utils base = new Utils();


    @Given("^Open \"([^\"]*)\" and navigate to Insly login \"([^\"]*)\"$")
    public void openAndNavigateToInslyLogin(String browser, String url) throws Throwable {
        base.openBrowser(browser);
        base.navigate(url);

    }

    @And("^I enter 'companyName' as \"([^\"]*)\"$")
    public void iEnterCompanyNameAs(String arg0) throws Throwable {

    }

    @And("^I type 'inslyAdd' as \"([^\"]*)\"$")
    public void iTypeInslyAddAs(String arg0) throws Throwable {

    }

    @And("^I select company profile as \"([^\"]*)\"$")
    public void iSelectCompanyProfileAs(String arg0) throws Throwable {

    }

    @And("^I select country as 'India'$")
    public void iSelectCountryAsIndia() {
    }

    @And("^I select Number of employees as '(\\d+)-(\\d+)'$")
    public void iSelectNumberOfEmployeesAs(int arg0, int arg1) {
    }

    @Then("^I select myself as 'A tech guy'$")
    public void iSelectMyselfAsATechGuy() {
    }


}
