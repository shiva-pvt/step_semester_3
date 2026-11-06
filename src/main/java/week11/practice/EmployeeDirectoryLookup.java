package week11.practice;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDirectoryLookup {

    static class EmployeeRecord {
        String employeeId;
        String department;

        EmployeeRecord(String employeeId, String department) {
            this.employeeId = employeeId;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(EmployeeRecord[] records) {
        Map<String, String> lookup = new HashMap<>();
        if (records == null) {
            return lookup;
        }

        for (EmployeeRecord record : records) {
            lookup.put(record.employeeId, record.department);
        }

        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        if (lookup == null || !lookup.containsKey(employeeId)) {
            return "Unknown";
        }
        return lookup.get(employeeId);
    }

    public static void main(String[] args) {
        EmployeeRecord[] records = {
            new EmployeeRecord("E245", "Finance"),
            new EmployeeRecord("E110", "Engineering"),
            new EmployeeRecord("E390", "Marketing"),
            new EmployeeRecord("E101", "Engineering")
        };

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
