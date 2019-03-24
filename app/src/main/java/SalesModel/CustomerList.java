package SalesModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomerList implements Serializable {
    private Map<String, CustomerModel> customers;

    public CustomerList() {
        customers = new HashMap<>();
    }

    public boolean addCustomer(String usr, String pw, Logger log) {
        if (customers.containsKey(usr))
            return false;

        CustomerModel newCustomer = new CustomerModel(usr, pw, log);
        customers.put(usr, newCustomer);
        return true;
    }

    public boolean ifCustomerExist(String usr) {
        return customers.containsKey(usr);
    }

    public CustomerModel getCustomer(String usr) {
        return customers.get(usr);
    }
}
