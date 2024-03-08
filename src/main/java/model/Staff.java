package model;

import java.sql.Timestamp;

public record Staff(int staff_id, String first_name, String last_name,
                    int address_id, String email, int store_id, boolean active,
                    String username, String password, Timestamp last_update,
                    byte[] picture) {
}
