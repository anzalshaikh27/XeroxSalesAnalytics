/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");
        SupplierDirectory suplierdirectory = business.getSupplierDirectory();

        Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");
        ProductCatalog productcatalog = supplier1.getProductCatalog();
        Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
        Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
        Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);
        Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
        Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
        Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
        Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
        Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);

        //       SupplierDirectory suplierdirectory = business.getSupplierDirectory();
        Supplier supplier2 = suplierdirectory.newSupplier("Epson");
        productcatalog = supplier2.getProductCatalog();
        Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
        Product products2p2 = productcatalog.newProduct("Scanner 14", 90000, 165000, 125000);
        Product products2p3 = productcatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
        Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
        Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
        Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
        Product products2p7 = productcatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
        Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);

// Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
// person representing sales organization        
        Person xeroxsalesperson001 = persondirectory.newPerson("Xerox sales");
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");

        Person hpsalesperson002 = persondirectory.newPerson("HP sales");
        Person hpmarketingperson002 = persondirectory.newPerson("HP marketing");
        Person hpadminperson002 = persondirectory.newPerson("HP admin");
        
        Person dellsalesperson003 = persondirectory.newPerson("Dell sales");
        Person dellmarketingperson003 = persondirectory.newPerson("Dell marketing");
        Person delladminperson003 = persondirectory.newPerson("Dell admin");
        
        Person applesalesperson004 = persondirectory.newPerson("Apple sales");
        Person applemarketingperson004 = persondirectory.newPerson("Apple marketing");
        Person appleadminperson004 = persondirectory.newPerson("Apple admin");
        
        Person samsungsalesperson005 = persondirectory.newPerson("Samsung sales");
        Person samsungmarketingperson005 = persondirectory.newPerson("Samsung marketing");
        Person samsungadminperson005 = persondirectory.newPerson("Samsung admin");
        
        Person oneplussalesperson006 = persondirectory.newPerson("OnePlus sales");
        Person oneplusmarketingperson006 = persondirectory.newPerson("OnePlus marketing");
        Person oneplusadminperson006 = persondirectory.newPerson("OnePlus admin");
        
        Person microsoftsalesperson007 = persondirectory.newPerson("Microsoft sales");
        Person microsoftmarketingperson007 = persondirectory.newPerson("Microsoft marketing");
        Person microsoftadminperson007 = persondirectory.newPerson("Microsoft admin");

// Create person objects to represent customer organizations. 
        Person person005 = persondirectory.newPerson("Dell");
        Person person006 = persondirectory.newPerson("Microsoft");
        Person person007 = persondirectory.newPerson("Google");
        Person person008 = persondirectory.newPerson("JP Morgan");
        Person person009 = persondirectory.newPerson("State street"); //we use this as customer
                // Additional Customers
        Person person010 = persondirectory.newPerson("Apple");
        Person person011 = persondirectory.newPerson("Amazon");
        Person person012 = persondirectory.newPerson("Tesla");

// Create Customers
        CustomerDirectory customedirectory = business.getCustomerDirectory();
        CustomerProfile customerprofile1 = customedirectory.newCustomerProfile(person005);
        CustomerProfile customerprofile2 = customedirectory.newCustomerProfile(person006);
        CustomerProfile customerprofile3 = customedirectory.newCustomerProfile(person007);
        CustomerProfile customerprofile4 = customedirectory.newCustomerProfile(person008);
        CustomerProfile customerprofile5 = customedirectory.newCustomerProfile(person009);
        CustomerProfile customerprofile6 = customedirectory.newCustomerProfile(person010);
        CustomerProfile customerprofile7 = customedirectory.newCustomerProfile(person011);
        CustomerProfile customerprofile8 = customedirectory.newCustomerProfile(person012);
       // CustomerProfile customerprofile8 = customedirectory.newCustomerProfile(person013);

// Create Sales people
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile = salespersondirectory.newSalesPersonProfile(xeroxsalesperson001);

        SalesPersonProfile salespersonprofile2 = salespersondirectory.newSalesPersonProfile(hpsalesperson002);
        SalesPersonProfile salespersonprofile3 = salespersondirectory.newSalesPersonProfile(dellsalesperson003);
        SalesPersonProfile salespersonprofile4 = salespersondirectory.newSalesPersonProfile(applesalesperson004);
        SalesPersonProfile salespersonprofile5 = salespersondirectory.newSalesPersonProfile(samsungsalesperson005);
        SalesPersonProfile salespersonprofile6 = salespersondirectory.newSalesPersonProfile(oneplussalesperson006);
        SalesPersonProfile salespersonprofile7 = salespersondirectory.newSalesPersonProfile(microsoftsalesperson007);
        
// Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

// Create Admins to manage the business
       EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
       EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);

// Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua1 = uadirectory.newUserAccount(salespersonprofile, "Sales", "XXXX"); /// Order products for one of the customers and performed by a sales person
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "XXXX"); /// order products for one of the customers and performed by a sales person
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "XXXX"); /// order products for one of the customers and performed by a sales person

// Process Orders on behalf of sales person and customer
        MasterOrderList masterorderlist = business.getMasterOrderList();
        Order order1 = masterorderlist.newOrder(customerprofile1, salespersonprofile);
        OrderItem oi1 = order1.newOrderItem(products1p1, 18000, 1);
        OrderItem oi2 = order1.newOrderItem(products1p2, 19500, 4);
        OrderItem oi3 = order1.newOrderItem(products1p3, 36500, 10);
        OrderItem oi4 = order1.newOrderItem(products1p4, 50000, 1);
        OrderItem oi5 = order1.newOrderItem(products1p5, 25000, 3);
        OrderItem oi6 = order1.newOrderItem(products1p6, 105000, 2);
        OrderItem oi7 = order1.newOrderItem(products1p7, 36500, 3);
        OrderItem oi8 = order1.newOrderItem(products1p8, 50000, 2);

        Order order2 = masterorderlist.newOrder(customerprofile2, salespersonprofile6);
        OrderItem oi9 = order2.newOrderItem(products1p1, 19000, 2);
        OrderItem oi10 = order2.newOrderItem(products1p2, 18500, 5);
        OrderItem oi11 = order2.newOrderItem(products1p3, 35500, 11);
        OrderItem oi12 = order2.newOrderItem(products1p4, 49000, 2);
        OrderItem oi13 = order2.newOrderItem(products1p5, 24000, 4);
        OrderItem oi14 = order2.newOrderItem(products1p6, 103000, 3);
        OrderItem oi15 = order2.newOrderItem(products1p7, 36400, 4);
        OrderItem oi16 = order2.newOrderItem(products1p8, 51000,3);
        
        Order order3 = masterorderlist.newOrder(customerprofile3, salespersonprofile7);
        OrderItem oi17 = order2.newOrderItem(products1p1, 19500, 3);
        OrderItem oi18 = order2.newOrderItem(products1p2, 19500, 4);
        OrderItem oi19 = order2.newOrderItem(products1p3, 33500, 11);
        OrderItem oi20 = order2.newOrderItem(products1p4, 48000, 2);
        OrderItem oi21 = order2.newOrderItem(products1p5, 27000, 4);
        OrderItem oi22 = order2.newOrderItem(products1p6, 109000, 5);
        OrderItem oi23 = order2.newOrderItem(products1p7, 32400, 2);
        OrderItem oi124 = order2.newOrderItem(products1p8, 55000,3);
        
        
Order order4 = masterorderlist.newOrder(customerprofile4, salespersonprofile2);
OrderItem oi25 = order4.newOrderItem(products2p1, 15000, 2);
OrderItem oi26 = order4.newOrderItem(products2p2, 18000, 3);
OrderItem oi27 = order4.newOrderItem(products2p3, 30000, 1);

Order order5 = masterorderlist.newOrder(customerprofile5, salespersonprofile3);
OrderItem oi28 = order5.newOrderItem(products2p4, 50000, 2);
OrderItem oi29 = order5.newOrderItem(products2p5, 22000, 4);
OrderItem oi30 = order5.newOrderItem(products2p6, 90000, 1);

Order order6 = masterorderlist.newOrder(customerprofile6, salespersonprofile4);
OrderItem oi31 = order6.newOrderItem(products1p1, 18000, 2);
OrderItem oi32 = order6.newOrderItem(products1p2, 25000, 1);
OrderItem oi33 = order6.newOrderItem(products1p3, 12000, 3);
      
        
        Order order7 = masterorderlist.newOrder(customerprofile7, salespersonprofile5);
        OrderItem oi134 = order7.newOrderItem(products1p1, 27000, 1);
        OrderItem oi35 = order7.newOrderItem(products1p2, 95000, 4);
        OrderItem oi36 = order7.newOrderItem(products1p3, 29500, 10);
        OrderItem oi37 = order7.newOrderItem(products1p4, 30000, 1);
        OrderItem oi38 = order7.newOrderItem(products1p5, 20000, 3);
        OrderItem oi39 = order7.newOrderItem(products1p6, 95000, 2);
        OrderItem oi40 = order7.newOrderItem(products1p7, 26500, 3);
        OrderItem oi41 = order7.newOrderItem(products1p8, 40000, 2);

        return business;

    }

}
