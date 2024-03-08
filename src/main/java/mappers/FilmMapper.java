package mappers;

import model.Film;
import utils.RowMapper;

import java.sql.ResultSet;

public class FilmMapper implements RowMapper<Film> {

	@Override
	public Film mapRow(ResultSet rs) throws Exception {
		return new Film(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
				rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
				rs.getDouble("rental_rate"), rs.getInt("length"), rs.getDouble("replacement_cost"),
				rs.getString("rating"), rs.getTimestamp("last_update"), rs.getString("special_features"),
				rs.getString("fulltext"));
	}

}
