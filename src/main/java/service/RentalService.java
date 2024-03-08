package service;

import mappers.RentalMapper;
import model.Rental;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class RentalService {
    public List<Rental> getAllRentals() {
        String query = "SELECT * FROM rental";
        return DBUtils.executeQuery(query, new RentalMapper());
    }

    public Rental getRentalById(int rentalId) {
        String query = "SELECT * FROM rental WHERE rental_id=" + rentalId;
        List<Rental> rentals = DBUtils.executeQuery(query, new RentalMapper());
        return rentals.isEmpty() ? null : rentals.get(0);
    }

    public Map<String, Object> getRentalByInventoryIdAndCustomerId(int rentalId) {
        String query = "SELECT inventory_id,customer_id FROM rental WHERE rental_id=" + rentalId;
        return DBUtils.executeQueryForMapList(query).get(0);
    }
}
