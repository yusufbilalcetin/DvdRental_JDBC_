package service;

import mappers.FilmMapper;
import model.Film;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class FilmService {

	public List<Film> getAllFilms() {
		String query = "SELECT * FROM film";
		return DBUtils.executeQuery(query, new FilmMapper());
	}

	public Film getFilmById(int filmId) {
		String query = "SELECT * FROM film WHERE film_id=" + filmId;
		List<Film> films = DBUtils.executeQuery(query, new FilmMapper());
		return films.isEmpty() ? null : films.get(0);
	}

	public Map<String, Object> getFilmTitleAndDescriptionById(int filmId) {
		String query = "SELECT title, description FROM film WHERE film_id=" + filmId;
		return DBUtils.executeQueryForMapList(query).get(0);
	}

}
