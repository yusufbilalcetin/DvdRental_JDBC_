package mappers;

import model.FilmDetails;
import utils.RowMapper;

import java.sql.ResultSet;

public class FilmDetailsMapper implements RowMapper<FilmDetails> {

	@Override
	public FilmDetails mapRow(ResultSet rs) throws Exception {
		return new FilmDetails(rs.getString("title"), rs.getString("description"), rs.getInt("release_year"),
				rs.getString("category"), rs.getString("actor_list"));
	}

}
