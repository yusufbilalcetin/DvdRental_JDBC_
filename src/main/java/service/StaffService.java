package service;

import mappers.StaffMapper;
import model.Staff;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class StaffService {
    public List<Staff> getAllStaffs() {
        String query = "SELECT * FROM staff";
        return DBUtils.executeQuery(query, new StaffMapper());
    }

    public Staff getStaffById(int staffId) {
        String query = "SELECT * FROM staff WHERE staff_id=" + staffId;
        List<Staff> staffs = DBUtils.executeQuery(query, new StaffMapper());
        return staffs.isEmpty() ? null : staffs.get(0);
    }

    public Map<String, Object> getStaffsByFirstNameAndLastName(int staffId) {
        String query = "SELECT first_name,last_name FROM staff WHERE staff_id=" + staffId;
        return DBUtils.executeQueryForMapList(query).get(0);
    }
}
