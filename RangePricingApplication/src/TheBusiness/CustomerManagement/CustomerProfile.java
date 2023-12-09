/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.CustomerManagement;

import java.util.ArrayList;
import TheBusiness.MarketModel.Market;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.Profile;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile extends Profile {

    ArrayList<Order> orders;
    ArrayList<Market> markets;
    
    private int orderItemsAboveTarget;

    public int getOrderItemsAboveTarget() {
        return orderItemsAboveTarget;
    }

    public void setOrderItemsAboveTarget(int orderItemsAboveTarget) {
        this.orderItemsAboveTarget = orderItemsAboveTarget;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(ArrayList<Market> markets) {
        this.markets = markets;
    }

    Person person;

    public CustomerProfile(Person p) {
        super(p);
        person = p;
        orders = new ArrayList();

    }
    
    @Override
    public String getRole(){
        return "Sales";
    }
    
    

    public int getTotalPricePerformance() {

        int total = 0;
    for (Order o : orders) {
        total += o.getOrderPricePerformance();
    }
    return total;
    }

    public int getNumberOfOrdersAboveTotalTarget() {
        //for each order in the customer order list 
        //calculate if order is positive (actual order total is greater than sum of item targets
        //if yes then add 1 to total 
        int sum = 0;
        for (Order o : orders) {
            if (o.isOrderAboveTotalTarget() == true) {
                sum = sum + 1;
            }
        }

        return sum;
    }

    public int getNumberOfOrdersBelowTotalTarget() {
        return 0;
    }
    //for each order in the customer order list 
    //calculate if order is negative
    //if yes then add 1 to total 

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public void addCustomerOrder(Order o) {
        orders.add(o);
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }

    public String getCustomerId() {
        return person.getPersonId();
    }

    public Person getPerson() {
        return person;
    }

}
