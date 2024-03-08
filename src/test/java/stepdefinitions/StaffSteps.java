package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Staff;
import service.StaffService;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StaffSteps {
    private Staff staff;
    private List<Staff> staffList;
    private StaffService staffService;
    private Map<String, Object> staffDetails;


    @Given("the staff service is up and running")
    public void theStaffServiceIsUpAndRunning() {
        staffService = new StaffService();
    }

    @When("I request a list of all staff details")
    public void ıRequestAListOfAllStaffDetails() {
        staffList = staffService.getAllStaffs();
    }

    @Then("I should receive a list containing all staff details in the database")
    public void ıShouldReceiveAListContainingAllStaffDetailsInTheDatabase() {
        assertThat(staffList).as("Check if the staff list is not null and not empty")
                .isNotNull()
                .isNotEmpty();
    }

    @When("I request the staff with staff_id {int}")
    public void ıRequestTheStaffWithStaff_id(int staffId) {
        staff = staffService.getStaffById(staffId);
    }

    @Then("I should receive the details of the staff with staff_id {int}")
    public void ıShouldReceiveTheDetailsOfTheStaffWithStaff_id(int staffId) {
        assertThat(staff).as("Check if the staff is not null and not empty")
                .isNotNull()
                .matches(x -> x.staff_id() == staffId);
    }

    @When("I request the first_name and last_name of the staff with staff_id {int}")
    public void ıRequestTheFirst_nameAndLast_nameOfTheStaffWithStaff_id(int staffId) {
        staffDetails = staffService.getStaffsByFirstNameAndLastName(staffId);
    }

    @Then("I should receive the first_name and last_name of the staff with staff_id {int}")
    public void ıShouldReceiveTheFirst_nameAndLast_nameOfTheStaffWithStaff_id(int staffId) {
        assertThat(staffDetails).as("Check if the staff is not null and contains keys as first_name, last_name")
                .isNotNull()
                .containsKeys("first_name", "last_name");

        String firstName = (String) staffDetails.get("first_name");
        String lastName = (String) staffDetails.get("last_name");

        assertThat(firstName).isEqualTo("Mike");
        assertThat(lastName).isEqualTo("Hillyer");
    }
}
