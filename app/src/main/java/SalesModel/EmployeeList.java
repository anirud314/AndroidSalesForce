package SalesModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author villa
 */


//import main.java.logger.model.Logger;
//import java.util.HashMap;
//import java.util.Map;

public class EmployeeList implements Serializable {
    private Map<String, EmployeeModel> employees;

    public EmployeeList() {
        employees = new HashMap<>();
    }

    public boolean addEmployee(String usr, String pw, Logger log, CustomerList customers) {
        if (employees.containsKey(usr))
            return false;

        EmployeeModel newEmployee = new EmployeeModel(usr, pw, log, customers);
        employees.put(usr, newEmployee);
        return true;
    }

    public boolean ifEmployeeExist(String usr) {
        return employees.containsKey(usr);
    }
}
