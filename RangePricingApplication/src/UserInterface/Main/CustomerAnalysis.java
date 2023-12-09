/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.Main;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.Order;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author anzal
 */
public class CustomerAnalysis {
 
    
public static ArrayList<CustomerProfile> findBestCustomers(ArrayList<Order> orders) {
    Map<CustomerProfile, Integer> customerItemsAboveTargetMap = new HashMap<>();

    for (Order order : orders) {
    if (order.isOrderAboveTotalTarget()) {
        int orderItemsAboveTarget = order.getNumberOfOrderItemsAboveTarget();
        if (orderItemsAboveTarget > 0) {
            CustomerProfile customer = order.getCustomer();
            int currentCount = customerItemsAboveTargetMap.getOrDefault(customer, 0);
            customerItemsAboveTargetMap.put(customer, currentCount + orderItemsAboveTarget);

            // Add debug print statements
            System.out.println("Customer: " + customer.getCustomerId());
            System.out.println("Order Items Above Target: " + orderItemsAboveTarget);
            System.out.println("Current Count: " + currentCount);
            System.out.println("Updated Count: " + customerItemsAboveTargetMap.get(customer));
        }
    }
}


    // Sorting the best customers based on total order price performance
ArrayList<CustomerProfile> bestCustomers = new ArrayList<>(customerItemsAboveTargetMap.keySet());
    // Sorting the best customers based on total order price performance and order items above target
Collections.sort(bestCustomers, (c1, c2) -> {
    int orderPricePerformance1 = c1.getTotalPricePerformance();
    int orderPricePerformance2 = c2.getTotalPricePerformance();
    int itemsAboveTarget1 = customerItemsAboveTargetMap.getOrDefault(c1, 0);
    int itemsAboveTarget2 = customerItemsAboveTargetMap.getOrDefault(c2, 0);

    // First, sort by order price performance in descending order
    int pricePerformanceComparison = Integer.compare(orderPricePerformance2, orderPricePerformance1);
    if (pricePerformanceComparison != 0) {
        return pricePerformanceComparison;
    }

    // If order price performance is the same, then sort by items above target in descending order
    return Integer.compare(itemsAboveTarget2, itemsAboveTarget1);
});

// Print the orders and best customers for debugging
System.out.println("All Orders:");
for (Order order : orders) {
    System.out.println("Order: " + order.getOrderTotal());
}

System.out.println("Best Customers:");
for (CustomerProfile customer : bestCustomers) {
    System.out.println("Customer: " + customer.getCustomerId());
    System.out.println("Order Items Above Target: " + customerItemsAboveTargetMap.getOrDefault(customer, 0));
}

// Limit the result to the top 3 customers
return new ArrayList<>(bestCustomers.subList(0, Math.min(bestCustomers.size(), 3)));
}


private static int calculateTotalOrderPricePerformance(ArrayList<Order> orders) {
    int totalOrderPricePerformance = 0;
    for (Order order : orders) {
        totalOrderPricePerformance += order.getOrderPricePerformance();
    }
    return totalOrderPricePerformance;
}

}
