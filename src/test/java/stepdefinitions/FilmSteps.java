package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Film;
import service.FilmService;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FilmSteps {

	private Film film;

	private List<Film> filmList;

	private FilmService filmService;

	private Map<String, Object> filmDetails;

	@Given("the film service is up and running")
	public void theActorServiceIsUpAndRunning() {
		filmService = new FilmService();
	}

	@When("I request a list of all films")
	public void ıRequestAListOfAllFilms() {
		filmList = filmService.getAllFilms();
	}

	@Then("I should receive a list containing all films in the database")
	public void ıShouldReceiveAListContainingAllFilmsInTheDatabase() {
		assertThat(filmList).as("Check if the film list is not null and not empty").isNotNull().isNotEmpty();

	}

	@When("I request the film with ID {int}")
	public void ıRequestTheFilmWithID(int filmId) {
		film = filmService.getFilmById(filmId);
	}

	@Then("I should receive the details of the film with ID {int}")
	public void ıShouldReceiveTheDetailsOfTheFilmWithID(int filmId) {
		assertThat(film).as("Check if the film is not null and has the correct ID")
			.isNotNull()
			.matches(x -> x.getFilm_Id() == (filmId), "Film ID should be" + filmId);
	}

	@When("I request the title and description of the film with ID {int}")
	public void ıRequestTheTitleAndDescriptionOfTheFilmWithID(int filmId) {
		filmDetails = filmService.getFilmTitleAndDescriptionById(filmId);
	}

	@Then("I should receive the title and description of the film with ID {int}")
	public void ıShouldReceiveTheTitleAndDescriptionOfTheFilmWithID(int filmId) {
		assertThat(filmDetails)
			.as("Check if the film details map is not null and contains the expected title and description")
			.isNotNull()
			.containsKeys("title", "description");

		String title = (String) filmDetails.get("title");
		String description = (String) filmDetails.get("description");

		assertThat(title).as("Check if the title is not null").isNotNull();

		assertThat(description).as("Check if the description is not null").isNotNull();
	}

}
