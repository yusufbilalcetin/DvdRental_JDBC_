package mappers;

import model.Payment;
import utils.RowMapper;

import java.sql.ResultSet;

public class PaymentMapper implements RowMapper<Payment> {

	@Override
	public Payment mapRow(ResultSet rs) throws Exception {
		return new Payment(rs.getInt("payment_id"), rs.getInt("customer_id"), rs.getInt("staff_id"),
				rs.getInt("rental_id"), rs.getDouble("amount"), rs.getTimestamp("payment_date"));
	}

}
