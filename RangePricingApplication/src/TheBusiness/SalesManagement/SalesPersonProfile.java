/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SalesManagement;

import java.util.ArrayList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonProfile extends Profile {
    ArrayList<Order> salesorders;
    private double salesPerformance;

    public double getSalesPerformance() {
        return salesPerformance;
    }

    public void setSalesPerformance(double salesPerformance) {
        this.salesPerformance = salesPerformance;
    }

    public void setSalesorders(ArrayList<Order> salesorders) {
        this.salesorders = salesorders;
    }

    public ArrayList<Order> getSalesorders() {
        return salesorders;
    }


    public SalesPersonProfile(Person p) {

        super(p); 
        salesorders = new ArrayList();

    }
    public void addSalesOrder(Order o){
        salesorders.add(o);
    }
    
     public int getSalesPerformanceForSalesPerson() {
        // Calculate and return the sales performance metric
        // This could be based on the total sales amount, number of orders, etc.
        // For illustration, let's assume it's the total number of sales orders.
        return salesorders.size();
    }
    
     public void calculateSalesPerformance() {
        // Logic to calculate sales performance based on orders, items, or any relevant criteria
        // You may need to customize this based on your business logic
        // For example, you can sum up the sales performance from associated orders or products.
        // This is just a placeholder, and you should replace it with your actual calculation.
        // For simplicity, I'm using a constant value here.
        double totalRevenue = 0.0;

    for (Order order : salesorders) {
        totalRevenue += order.calculateTotalRevenue();
    }

    this.salesPerformance = totalRevenue;
    }
     
     
    @Override
    public String getRole(){
        return  "Sales";
    }

}
