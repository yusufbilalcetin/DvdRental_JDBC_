package service;

import mappers.FilmDetailsMapper;
import model.FilmDetails;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class FilmDetailsService {

	public List<FilmDetails> getAllFilmDetails() {
		String query = "SELECT\n" + "    f.title AS title,\n" + "    f.description AS description,\n"
				+ "    f.release_year AS release_year,\n" + "    c.name AS category,\n"
				+ "    string_agg(a.first_name || ' ' || a.last_name, ', ') AS actor_list\n" + "FROM\n" + "    film f\n"
				+ "JOIN\n" + "    film_category fc ON f.film_id = fc.film_id\n" + "JOIN\n"
				+ "    category c ON fc.category_id = c.category_id\n" + "JOIN\n"
				+ "    film_actor fa ON f.film_id = fa.film_id\n" + "JOIN\n"
				+ "    actor a ON fa.actor_id = a.actor_id\n" + "GROUP BY\n"
				+ "    f.title, f.description, f.release_year, c.name;";
		return DBUtils.executeQuery(query, new FilmDetailsMapper());
	}

	public FilmDetails getFilmDetailsByTitle(String title) {
		String query = "WITH film_info AS (\n" + "    SELECT\n" + "        f.title AS title,\n"
				+ "        f.description AS description,\n" + "        f.release_year AS release_year,\n"
				+ "        c.name AS category,\n"
				+ "        string_agg(a.first_name || ' ' || a.last_name, ', ') AS actor_list\n" + "    FROM\n"
				+ "        film f\n" + "    JOIN\n" + "        film_category fc ON f.film_id = fc.film_id\n"
				+ "    JOIN\n" + "        category c ON fc.category_id = c.category_id\n" + "    JOIN\n"
				+ "        film_actor fa ON f.film_id = fa.film_id\n" + "    JOIN\n"
				+ "        actor a ON fa.actor_id = a.actor_id\n" + "    GROUP BY\n"
				+ "        f.title, f.description, f.release_year, c.name\n" + ")\n"
				+ "SELECT * FROM film_info WHERE title =" + "'" + title + "'";
		List<FilmDetails> films = DBUtils.executeQuery(query, new FilmDetailsMapper());
		return films.isEmpty() ? null : films.get(0);
	}

	public Map<String, Object> getFilmCategoryAndReleaseYearByTitle(String title) {
		String query = "SELECT\n" + "    f.title AS title,\n" + "    f.release_year AS release_year,\n"
				+ "    c.name AS category\n" + "FROM\n" + "    film f\n" + "JOIN\n"
				+ "    film_category fc ON f.film_id = fc.film_id\n" + "JOIN\n"
				+ "    category c ON fc.category_id = c.category_id\n" + "WHERE\n" + "    f.title = " + "'" + title
				+ "'" + "GROUP BY\n" + "    f.title, f.release_year, c.name";
		return DBUtils.executeQueryForMapList(query).get(0);
	}

}
