package mappers;

import model.Rental;
import utils.RowMapper;

import java.sql.ResultSet;

public class RentalMapper implements RowMapper<Rental> {

	@Override
	public Rental mapRow(ResultSet rs) throws Exception {
		return new Rental(rs.getInt("rental_id"), rs.getTimestamp("rental_date"), rs.getInt("inventory_id"),
				rs.getInt("customer_id"), rs.getTimestamp("return_date"), rs.getInt("staff_id"),
				rs.getTimestamp("last_update"));
	}

}
