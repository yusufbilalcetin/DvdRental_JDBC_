package mappers;

import model.Staff;
import utils.RowMapper;

import java.sql.ResultSet;

public class StaffMapper implements RowMapper<Staff> {
    @Override
    public Staff mapRow(ResultSet rs) throws Exception {
        return new Staff(rs.getInt("staff_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("address_id"),
                rs.getString("email"),
                rs.getInt("store_id"),
                rs.getBoolean("active"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getTimestamp("last_update"),
                rs.getBytes("picture")
        );
    }
}
