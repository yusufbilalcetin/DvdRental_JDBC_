package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.FilmDetails;
import service.FilmDetailsService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class FilmDetailsSteps {

	private FilmDetails filmDetails;

	private List<FilmDetails> filmDetailsList;

	private FilmDetailsService filmDetailsService;

	private Map<String, Object> filmDetailsMap;


	@Given("the film details service is up and running")
	public void theFilmDetailsServiceIsUpAndRunning() {
		filmDetailsService = new FilmDetailsService();
	}

	@When("I request a list of film details")
	public void ıRequestAListOfFilmDetails() {
		filmDetailsList = filmDetailsService.getAllFilmDetails();
	}

	@Then("I should receive a list containing film details in the database")
	public void ıShouldReceiveAListContainingFilmDetailsInTheDatabase() {
		assertThat(filmDetailsList).as("Check if the film details list is not null and not empty")
			.isNotNull()
			.isNotEmpty();
	}

	@When("I request the film details with title {string}")
	public void ıRequestTheFilmDetailsWithTitle(String title) {
		filmDetails = filmDetailsService.getFilmDetailsByTitle(title);
	}

	@Then("I should receive the details of the {string}")
	public void ıShouldReceiveTheDetailsOfThe(String title) {
		assertThat(filmDetails).as("Check if the film details is not null and matches truly")
			.isNotNull()
			.matches(x -> Objects.equals(x.title(), title));
	}

	@When("I request the category and release year of the film with {string}")
	public void ıRequestTheCategoryAndReleaseYearOfTheFilmWith(String title) {
		filmDetailsMap = filmDetailsService.getFilmCategoryAndReleaseYearByTitle(title);
	}

	@Then("I should receive the category and release year of the film with {string}")
	public void ıShouldReceiveTheCategoryAndReleaseYearOfTheFilmWith(String title) {
		assertThat(filmDetailsMap)
			.as("Check if the film details map is not null and contains the expected category and release year")
			.isNotNull()
			.containsKeys("category", "release_year");

		String category = (String) filmDetailsMap.get("category");
		int release_year = (int) filmDetailsMap.get("release_year");

		assertThat(category).as("Check if the category is not null").isNotNull();

		assertThat(release_year).as("Check if the release year is not null").isNotNull();
	}

}
