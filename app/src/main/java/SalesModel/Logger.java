/**
 * Written by Kyle Truong
 */

package SalesModel;

//import main.java.sale.model.Sale;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Logs all transaction actions between an employee and their customer
 * Employees and customers do not interact directly with each other
 * Instead they interact with the logger
 */
public class Logger implements Serializable{
    // Record of a business's open(pending) and closed(finalized) sales
    // Integer represents the specific sale id, used for O(1) lookup
    public Map<Integer, Sale> openSales;
    public Map<Integer, Sale> closedSales;

    public Logger() {
        openSales = new HashMap<>();
        closedSales = new HashMap<>();
    }

    /**
     * Public methods
     */

    // Accept new, pending sale from employee and notify customer
    public void acceptNewSale(Sale sale) {
        openSales.put(sale.getId(), sale);
        giveNewSaleToCustomer(sale);
    }

    // Accept closed sale from customer and notify employee
    public void acceptClosedSale(int sale_id) {
        Sale closedSale = openSales.remove(sale_id);
        closedSales.put(sale_id, closedSale);
        giveClosedSaleToEmployee(sale_id);
    }

    public boolean doesSaleIdExist(int id) {
        return openSales.containsKey(id) || closedSales.containsKey(id);
    }


    /**
     * Private helper methods
     */
    private void giveNewSaleToCustomer(Sale sale) {
        sale.getCustomer().retrieveNewSale(sale);
    }

    private void giveClosedSaleToEmployee(int sale_id) {
        closedSales.get(sale_id).getEmployee().closeSale(sale_id);
    }
}