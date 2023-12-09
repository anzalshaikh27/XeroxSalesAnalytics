/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Business;

import MarketingManagement.MarketingPersonDirectory;
import TheBusiness.MarketModel.ChannelCatalog;
import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.ProductManagement.ProductsReport;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.Order;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.awt.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role
    MasterOrderList masterorderlist;
    CustomerDirectory customers;
    SupplierDirectory suppliers;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
    MarketChannelComboCatalog marketChannelComboCatalog;
    SolutionOfferCatalog solutionoffercatalog;
    CustomerDirectory customerdirectory;
     EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;
    MasterSolutionOrderList mastersolutionorderlist;
    Market market;


    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();
        market = new Market(name);

        employeedirectory = new EmployeeDirectory(this);
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);

        marketcatalog = new MarketCatalog();

        channelcatalog = new ChannelCatalog();

        Channel c = channelcatalog.newChannel("tv");
        market.addValidChannel(c);
        c = channelcatalog.newChannel("");

        marketChannelComboCatalog = new MarketChannelComboCatalog();
        MarketChannelAssignment mca2 = marketChannelComboCatalog.newMarketChannelCombo(market, c);

        solutionoffercatalog = new SolutionOfferCatalog();
        mastersolutionorderlist  = new MasterSolutionOrderList();

    }
  
    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();

    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();

    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }

    public MarketCatalog getMarketCatalog() {
        return marketcatalog;
    }

    public ChannelCatalog getChannelCatalog() {
        return channelcatalog;
    }
    public SolutionOfferCatalog getSolutionOfferCatalog(){
        return solutionoffercatalog;
    }
    public MarketChannelComboCatalog getMarketChannelComboCatalog() {

        return marketChannelComboCatalog;
    }
    public MasterSolutionOrderList getMasterSolutionOrderList(){
        return mastersolutionorderlist;
    }
          public EmployeeDirectory getEmployeeDirectory() {
         return employeedirectory;
      }

          
          
          public ArrayList<CustomerProfile> findTopCustomersAboveTarget() {
        ArrayList<CustomerProfile> topCustomers = new ArrayList<>();

        // Iterate through the customer profiles
        for (CustomerProfile customerProfile : customerdirectory.getCustomerlist()) {
            double totalPurchase = calculateTotalPurchase(customerProfile);

            // Compare total purchase with target price (adjust the target price as needed)
            double targetPrice = 50000; // You can adjust this value as needed
            if (totalPurchase > targetPrice) {
                topCustomers.add(customerProfile);
            }
        }

        // Sort the top customers by their total purchase (descending order)
        topCustomers.sort(Comparator.comparingDouble(this::calculateTotalPurchase).reversed());

        // Get the top 3 customers
        int limit = Math.min(3, topCustomers.size());
        return new ArrayList<>(topCustomers.subList(0, limit));
    }

    // Helper method to calculate the total purchase for a customer
    private double calculateTotalPurchase(CustomerProfile customerProfile) {
        double totalPurchase = 0;

        // Iterate through the orders of the customer
        for (Order order : masterorderlist.getOrders()) {
            if (order.getCustomer() == customerProfile) {
                // Sum up the total price of each order item
                totalPurchase += order.getOrderTotal();
            }
        }

        return totalPurchase;
    }
          
          
          
          
          
          public void getTop3NegotiatedSolutionsByMarketSegment() {
        MasterSolutionOrderList masterSolutionOrderList = getMasterSolutionOrderList();
        MarketChannelComboCatalog comboCatalog = getMarketChannelComboCatalog();
        SolutionOfferCatalog solutionOfferCatalog = getSolutionOfferCatalog();

        ArrayList<SolutionOffer> allSolutions = solutionOfferCatalog.getSolutionoffers();

        // Create a list to store solutions with their revenue performance
        ArrayList<SolutionRevenue> solutionRevenues = new ArrayList<>();

        for (SolutionOffer solutionOffer : allSolutions) {
            MarketChannelAssignment combo = comboCatalog.getComboBySolutionOffer(solutionOffer);
            double revenue = masterSolutionOrderList.getRevenueByMarketChannelCombo(combo);
            double targetRevenue = solutionOffer.getSolutionPrice();

            // Calculate performance (revenue as a percentage of target revenue)
            double performance = (revenue / targetRevenue) * 100;

            solutionRevenues.add(new SolutionRevenue(solutionOffer, combo, performance));
        }

        // Sort solutions based on performance in descending order
        Collections.sort(solutionRevenues, Comparator.comparingDouble(SolutionRevenue::getPerformance).reversed());

//        // Display the top 3 solutions
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("                                                  QUESTION 1                                                                ");
//        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("TOP 3 PRODUCTS ");
//        System.out.println("----------------------------------------------------------------------------------------------------------------------------");

        int count = 1;
        for (SolutionRevenue solutionRevenue : solutionRevenues) {
            if (count <= 3) {
                System.out.println("Number of Quantity Sold:   " + solutionRevenue.getSolutionOffer().getSolutionPrice());
                System.out.println("List of Products with Same Quantities:  " + solutionRevenue.getSolutionOffer().getRevenues());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                count++;
            } else {
                break;
            }
        }
    }

    // Inner class to represent Solution and its revenue performance
    private static class SolutionRevenue {
        private final SolutionOffer solutionOffer;
        private final MarketChannelAssignment combo;
        private final double performance;

        public SolutionRevenue(SolutionOffer solutionOffer, MarketChannelAssignment combo, double performance) {
            this.solutionOffer = solutionOffer;
            this.combo = combo;
            this.performance = performance;
        }

        public SolutionOffer getSolutionOffer() {
            return solutionOffer;
        }

        public MarketChannelAssignment getCombo() {
            return combo;
        }

        public double getPerformance() {
            return performance;
        }
    }
          
          
}
