/**
 * Written by Alan Noun
 */

package SalesModel;

//import main.java.customer.model.CustomerModel;
//import main.java.logger.model.Logger;
//import main.java.sale.model.Sale;
import java.io.Serializable;
import java.util.*;

public class EmployeeModel implements Serializable {
    // Member fields
    public Map<Integer, Sale> openSales;
    public Map<Integer, Sale> closedSales;
    public CustomerList customers;
    public List<String> options;
    private Logger logger;
    private int id;
    private final int MAX_SALE_ID = 10000;
    private String username, password;

    // Constructor


    public EmployeeModel(String usr, String pw, Logger log, CustomerList customers) {
        logger = log;
        closedSales = new HashMap<>();
        openSales = new HashMap<>();
        this.customers = customers;
        username = usr;
        password = pw;

        options = new ArrayList<>();
        options.add("Open Sales");
        options.add("Closed Sales");
        options.add("New Sale");
    }

    // Retrieve a customer by their unique id


    public CustomerModel getCustomer(String username) {
        return customers.getCustomer(username);
    }

    // I think we don't need this anymore?
//    public boolean doesCustExist(int id) {
//        return customers.containsKey(id);
//    }

    // Create a new sale with a unique id then offer it a specific customer
    public void offerNewSale(String customer_username) {
        Random rand = new Random();
        int n = rand.nextInt(MAX_SALE_ID);

        while (logger.doesSaleIdExist(n))
            n = rand.nextInt(MAX_SALE_ID);

        // Create sale object
        Sale newSale;


        newSale = new Sale(this, getCustomer(customer_username), n);

//        newSale.setEmployee(this);

        openSales.put(n, newSale);
        logger.acceptNewSale(newSale);
    }

    // Move an open sale to a closed sale
    public void closeSale(int sale_id) {
        Sale closedSale = openSales.remove(sale_id);
        closedSales.put(sale_id, closedSale);
    }
//    public void createCust(int n) {
//
//
//        CustomerModel cust = new CustomerModel(n, logger);
//        customers.put(n, cust);
//    }

    public Map<Integer, Sale> getClosedSales() {
        return closedSales;
    }

    public Map<Integer, Sale> getOpenSales() {
        return openSales;
    }

    public List<String> getOptions() {
        return options;
    }

    //    public void showClosedSales() {
//        closedSales.forEach((k,v) -> System.out.println("Sale ID: "+k+" Customer:"+v.getCustomer()));
//    }
//    public void showOpenSales() {
//        openSales.forEach((k,v) -> System.out.println("Sale ID: "+k+" Customer:"+v.getCustomer().getID()));
//    }
}
