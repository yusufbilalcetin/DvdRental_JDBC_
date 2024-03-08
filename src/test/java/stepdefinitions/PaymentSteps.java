package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Payment;
import service.PaymentService;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentSteps {
	private Payment payment;

	private List<Payment> paymentList;

	private PaymentService paymentService;

	private Map<String, Object> paymentDetails;


	@Given("the payment service is up and running")
	public void thePaymentServiceIsUpAndRunning() {
		paymentService = new PaymentService();
	}

	@When("I request a list of all payments")
	public void ıRequestAListOfAllPayments() {
		paymentList = paymentService.getAllPayments();
	}

	@Then("I should receive a list containing all payments in the database")
	public void ıShouldReceiveAListContainingAllPaymentsInTheDatabase() {
		assertThat(paymentList).as("Check if the payment list is not null and not empty").isNotNull().isNotEmpty();
	}

	@When("I request the payment with payment_id {int}")
	public void ıRequestThePaymentWithPayment_id(int paymentId) {
		payment = paymentService.getPaymentById(paymentId);
	}

	@Then("I should receive the details of the payment with payment_id {int}")
	public void ıShouldReceiveTheDetailsOfThePaymentWithPayment_id(int paymentId) {
		assertThat(payment).as("Check if the payment Id is not null and not empty")
			.isNotNull()
			.matches(x -> x.getPayment_id() == paymentId);
	}

	@When("I request the customer_id and staff_id of the payment with payment_id {int}")
	public void ıRequestTheCustomer_idAndStaff_idOfThePaymentWithPayment_id(int paymentId) {
		paymentDetails = paymentService.getPaymentByCustomerIdAndStaffId(paymentId);
	}

	@Then("I should receive the customer_id and staff_id of the payment with payment_id {int}")
	public void ıShouldReceiveTheCustomer_idAndStaff_idOfThePaymentWithPayment_id(int paymentId) {
		assertThat(paymentDetails)
			.as("Check if the payment details map is not null and contains the expected customer_id and staff_id")
			.isNotNull()
			.containsKeys("customer_id", "staff_id");
		int customer_id = (int) paymentDetails.get("customer_id");
		int staff_id = (int) paymentDetails.get("staff_id");

		assertThat(customer_id).as("Check if the customer_id is not null").isNotNull();
		assertThat(staff_id).as("Check if the staff_id is not null").isNotNull();

	}

}
