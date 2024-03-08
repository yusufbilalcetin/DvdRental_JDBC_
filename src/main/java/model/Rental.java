package model;

import java.sql.Timestamp;

public record Rental(int rental_id, Timestamp rental_date, int inventory_id, int customer_id, Timestamp return_date,
		int staff_id, Timestamp last_update) {
}
