package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private int payment_id;

	private int customer_id;

	private int staff_id;

	private int rental_id;

	private double amount;

	private Timestamp payment_date;

}
