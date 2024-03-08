package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Rental;
import service.RentalService;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalSteps {
    private Rental rental;
    private RentalService rentalService;
    private List<Rental> rentalList;
    private Map<String, Object> rentalDetails;


    @Given("the rental service is up and running")
    public void theRentalServiceIsUpAndRunning() {
        rentalService = new RentalService();
    }

    @When("I request a list of all rentals")
    public void ıRequestAListOfAllRentals() {
        rentalList = rentalService.getAllRentals();
    }

    @Then("I should receive a list containing all rental details in the database")
    public void ıShouldReceiveAListContainingAllRentalDetailsInTheDatabase() {
        assertThat(rentalList).as("Check if the rental list is not null and not empty")
                .isNotNull()
                .isNotEmpty();
    }

    @When("I request the rental with rental_id {int}")
    public void ıRequestTheRentalWithRental_id(int rentalId) {
        rental = rentalService.getRentalById(rentalId);
    }

    @Then("I should receive the details of the rental with rental_id {int}")
    public void ıShouldReceiveTheDetailsOfTheRentalWithRental_id(int rentalId) {
        assertThat(rental).as("Check if the rental Id is not null and not empty")
                .isNotNull()
                .matches(x -> x.rental_id() == rentalId);
    }

    @When("I request the inventory_id and customer_id of the rental with rental_id {int}")
    public void ıRequestTheInventory_idAndCustomer_idOfTheRentalWithRental_id(int rentalId) {
        rentalDetails = rentalService.getRentalByInventoryIdAndCustomerId(rentalId);
    }

    @Then("I should receive the inventory_id and customer_id of the rental with rental_id {int}")
    public void ıShouldReceiveTheInventory_idAndCustomer_idOfTheRentalWithRental_id(int rentalId) {
        assertThat(rentalDetails).as("Check if the rental details map is not null and contains the expected inventory_id and customer_id")
                .isNotNull()
                .containsKeys("inventory_id", "customer_id");

        int inventory_id = (int) rentalDetails.get("inventory_id");
        int customer_id = (int) rentalDetails.get("customer_id");

        assertThat(inventory_id).as("Check if the inventory_id is not null").isNotNull();
        assertThat(customer_id).as("Check if the customer_id is not null").isNotNull();
    }
}
