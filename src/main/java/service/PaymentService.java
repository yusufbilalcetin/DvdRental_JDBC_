package service;

import mappers.PaymentMapper;
import model.Payment;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class PaymentService {

	public List<Payment> getAllPayments() {
		String query = "SELECT * FROM payment";
		return DBUtils.executeQuery(query, new PaymentMapper());
	}

	public Payment getPaymentById(int paymentId) {
		String query = "SELECT * FROM payment WHERE payment_id=" + paymentId;
		List<Payment> payments = DBUtils.executeQuery(query, new PaymentMapper());
		return payments.isEmpty() ? null : payments.get(0);
	}

	public Map<String, Object> getPaymentByCustomerIdAndStaffId(int PaymentId) {
		String query = "SELECT customer_id,staff_id FROM payment WHERE payment_id=" + PaymentId;
		return DBUtils.executeQueryForMapList(query).get(0);
	}

}
