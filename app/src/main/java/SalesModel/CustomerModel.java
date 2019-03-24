/**
 * Written by Kyle Truong
 */

package SalesModel;

//import main.java.logger.model.Logger;
//import main.java.sale.model.Sale;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CustomerModel implements Serializable{
    // Member fields
    public Map<Integer, Sale> openSales;
    public Map<Integer, Sale> closedSales;
    Logger logger;
    private String username, password;

    // Constructor
    public CustomerModel(String usr, String pw, Logger log) {
        openSales = new HashMap<>();
        closedSales = new HashMap<>();
        logger = log;
        username = usr;
        password = pw;
    }

    // Retrieve a new sale offer created by an employee
    public void retrieveNewSale(Sale sale) {
        openSales.put(sale.getId(), sale);
    }

    // Moves a sale from open to closed
    // Notify the logger that the sale has been closed
    public void closeSale(int sale_id, boolean decision) {
        Sale closedSale = openSales.remove(sale_id);
        closedSale.setSaleDecision(decision);
        closedSales.put(closedSale.getId(), closedSale);
        logger.acceptClosedSale(closedSale.getId());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}