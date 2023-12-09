/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Profile;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import UserInterface.Main.WorkSpaceProfiles.BusinessManagerWorkAreaJPanel;
import UserInterface.Main.WorkSpaceProfiles.MarketingManagerWorkAreaJPanel1;
import UserInterface.Main.WorkSpaceProfiles.SalesPersonWorkAreaJPanel;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kal bugrara
 */
public class PricingMainFrame extends javax.swing.JFrame {

    
    public void displayquestion2() {
    ArrayList<CustomerProfile> topCustomers = business.findTopCustomersAboveTarget();

    //System.out.println("Question 2 -----------------------------------------Top 3 Customers Above Target Price:------------------------------------------------------------------------------------------------");
    
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                        QUESTION 2                                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("TOP 3 BEST CUSTOMERS:");
    
        System.out.println("---------------------------------------------------------------------------------------");

    for (int i = 0; i < topCustomers.size(); i++) {
        System.out.println((i + 1) + ". Customer ID: " + topCustomers.get(i).getPerson().getPersonId());

        // Print information about each order associated with the customer
        for (Order order : topCustomers.get(i).getOrders()) {
            System.out.println("   Total Revenue: " + order.getOrderTotal());
            System.out.println("   Order Price Performance: " + order.getOrderPricePerformance());
            System.out.println("   Number of Items Above Target: " + order.getNumberOfOrderItemsAboveTarget());
        }
        System.out.println();
    }
    
                    System.out.println("---------------------------------------------------------------------------------------");

    
}
    
    
    
    public void calculateMarginalRevenueByMarket() {
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        ArrayList<SalesPersonProfile> salespersons = salespersondirectory.getSalespersonlist();

//        System.out.println("Question 4-----------------------------------Market that is above or below expected target (actual minus target)----------------------------------------");
//        System.out.println("Target Revenue Assumed = 15000");
//        System.out.println();
//        
        
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                        QUESTION 4                                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Market that is above or below expected target:");
        System.out.println("Target Revenue Assumed = 15000");
        System.out.println();
    
        System.out.println("---------------------------------------------------------------------------------------");
        
        
        
        for (SalesPersonProfile salesperson : salespersons) {
            double totalActualRevenue = 0.0;

            // Calculate actual revenue for each order of the salesperson
            for (Order order : salesperson.getSalesorders()) {
                totalActualRevenue += order.calculateTotalRevenue();
            }

            // You may have a target revenue for each salesperson. For illustration, let's assume a target value.
            double targetRevenue = 15000.0; // Replace this with your actual target revenue value

            double marginalRevenue = totalActualRevenue - targetRevenue;

            // Output results for each salesperson
            System.out.println("Salesperson: " + salesperson.getPerson().getPersonId());
            System.out.println("Total Actual Revenue: " + totalActualRevenue);
           // System.out.println("Target Revenue: " + targetRevenue);
            System.out.println("Marginal Revenue: " + marginalRevenue);
            System.out.println("Status: " + (marginalRevenue > 0 ? "Above Target" : "Below Target"));
        System.out.println("---------------------------------------------------------------------------------------");
        }
    }
    
    
    
    
public void optimizePriceRanges() {
    SupplierDirectory supplierDirectory = business.getSupplierDirectory();

    //System.out.println("----------------Question 5----------------------------------------------------------------------------------");



System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                        QUESTION 5                                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("PRICE OPTIMIZATION:");
        System.out.println("Assuming 10% ceiling Price Increase ");
System.out.println("If sales Volumes is above 5lakhs, 20% markup is applied.");
System.out.println("If sales quantity is above 5lakhs, 10% markup is applied.");
System.out.println("");
    
        System.out.println("---------------------------------------------------------------------------------------");
        


    for (Supplier supplier : supplierDirectory.getSuplierList()) {
        ProductCatalog productCatalog = supplierDirectory.getProductCatalog(supplier);

        for (Product product : productCatalog.getProductList()) {
            // Get the current cost and sales quantity
            double currentCost = product.getTargetPrice();
            int salesVolumes = product.getSalesVolume();

            // Determine the desired markup based on sales quantity
            double desiredMarkup = calculateDesiredMarkup(salesVolumes);

            // Update price ranges based on the optimization logic
            int newTargetPrice = (int) (currentCost * (1 + desiredMarkup));
            int newCeilingPrice = (int) (newTargetPrice * 1.1); // Assume a 10% ceiling increase

            // Update the product's price ranges
            product.setTargetPrice(newTargetPrice);
            product.setCeilingPrice(newCeilingPrice);

            System.out.println("Current Cost: "+ currentCost);
            System.out.println(" Total Sales Volumes: " + salesVolumes);
            System.out.println("Optimized Price Ranges for Product " + product.getName() +
                    ": Target Price = " + product.getTargetPrice() +
                    ", Ceiling Price = " + product.getCeilingPrice());
            System.out.println("");
        }
    }
    
            System.out.println("---------------------------------------------------------------------------------------");

    
}

public double calculateDesiredMarkup(int salesVolumes) {
    // Your optimization logic goes here
    // This is a simple example, you can customize it based on your business requirements
    if (salesVolumes > 500000) {
        return 0.2; // If sales quantity is above 100, apply a 20% markup
    } else {
        return 0.1; // If sales quantity is below 100, apply a 10% markup
    }
}


    Business business;
    MasterOrderList masterOrderList;
    //Channel channel;

    /**
     * Creates new form PricingMainFrame
     */

    public PricingMainFrame() {
        initComponents();
        
        

        business = ConfigureABusiness.initialize();
        
        masterOrderList = business.getMasterOrderList();
      
        business.getTop3NegotiatedSolutionsByMarketSegment();
        
         SalesPersonDirectory salesPersonDirectory = business.getSalesPersonDirectory();
         

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("                                      Sales Analytics Report                                      ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        

         
         
         // *******************************************Question 1
         //ArrayList<SalesPersonProfile> topSalespeople = salesPersonDirectory.getTopSalesPeople(3);

        // Iterate through the top salespeople
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                        QUESTION 1                                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("TOP 3 BEST NEGOTIATED SOLUTIONS:");
        
                System.out.println("---------------------------------------------------------------------------------------");

//        for (SalesPersonProfile salesPersonProfile : topSalespeople) {
//            
//            System.out.println("Salesperson: " + salesPersonProfile.getPerson().getPersonId());
//            System.out.println("Sales Performance: (solutions sold above target) " + salesPersonProfile.getSalesPerformance());
//
//            System.out.println();

        Map<String, ArrayList<OrderItem>> marketSegments = new HashMap<>();

        MasterOrderList masterOrderList = business.getMasterOrderList();
        for (Order order : masterOrderList.getOrders()) {
            for (OrderItem orderItem : order.getOrderitems()) {
                String marketSegment = order.getCustomer().getPerson().getPersonId();
                marketSegments.computeIfAbsent(marketSegment, k -> new ArrayList<>()).add(orderItem);
            }
        }

        // Calculate the total negotiated price for each market segment
        Map<String, Double> totalNegotiatedPrices = new HashMap<>();
        for (Map.Entry<String, ArrayList<OrderItem>> entry : marketSegments.entrySet()) {
            double totalNegotiatedPrice = entry.getValue().stream()
                    .mapToDouble(OrderItem::getActualPrice)
                    .sum();
            totalNegotiatedPrices.put(entry.getKey(), totalNegotiatedPrice);
        }

        // Sort market segments by total negotiated price in descending order
        ArrayList<Map.Entry<String, Double>> sortedMarketSegments = new ArrayList<>(totalNegotiatedPrices.entrySet());
        Collections.sort(sortedMarketSegments, (entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

        // Display top 3 best-negotiated solutions by market segments
        int count = 0;
        for (Map.Entry<String, Double> entry : sortedMarketSegments) {
            String marketSegment = entry.getKey();
            ArrayList<OrderItem> orderItems = marketSegments.get(marketSegment);
            Collections.sort(orderItems, (item1, item2) -> Double.compare(item2.getActualPrice(), item1.getActualPrice()));

            System.out.println("Market Segment: " + marketSegment);
            //System.out.println("Top 3 Best-Negotiated Solutions:");
            for (int i = 0; i < Math.min(3, orderItems.size()); i++) {
                OrderItem orderItem = orderItems.get(i);
                System.out.println("Product: " + orderItem.getSelectedProduct().getName()+
                        ", Negotiated Price: " + orderItem.getActualPrice());
                
            }
              System.out.println("---------------------------------------------------------------------------------------");

            count++;
            if (count >= 3) {
                break; // Display top 3 market segments only
            }
        }
//        }
                 System.out.println("---------------------------------------------------------------------------------------");

         

//**********************************************************Question 2
         
         
         displayquestion2();
         
         
         
         
      //*****************************************************************Question 3   
       ArrayList<SalesPersonProfile> salespeople = salesPersonDirectory.getSalespersonlist();

        // Calculate and store the total sales revenue for each salesperson
        Map<SalesPersonProfile, Double> salesPerformanceMap = new HashMap<>();

        for (SalesPersonProfile salesperson : salespeople) {
            double totalSalesRevenue = calculateTotalSalesRevenue(salesperson);
            salesPerformanceMap.put(salesperson, totalSalesRevenue);
        }

        // Sort the salespeople based on sales performance (descending order)
        ArrayList<Map.Entry<SalesPersonProfile, Double>> sortedSalesPerformance = (ArrayList<Map.Entry<SalesPersonProfile, Double>>) salesPerformanceMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toList());

        // Display the top 3 salespeople
        //System.out.println("Question 3 --------------------------------  : Top 3 Salespeople Above Target Price:-----------------------------------------------------------------------------");
        
        
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                                        QUESTION 3                                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("TOP 3 BEST SALES PERSONS:");
    
        System.out.println("---------------------------------------------------------------------------------------");
        
        
        for (int i = 0; i < Math.min(3, sortedSalesPerformance.size()); i++) {
            Map.Entry<SalesPersonProfile, Double> entry = sortedSalesPerformance.get(i);
            SalesPersonProfile salesperson = entry.getKey();
            double totalSalesRevenue = entry.getValue();

            System.out.println((i + 1) + ". Salesperson: " + salesperson.getPerson().getPersonId());
            System.out.println("   Sales Performance (Sold higher than target) : " + totalSalesRevenue);
        }
        
                System.out.println("---------------------------------------------------------------------------------------");

         
        // ********************************************************Question 4
        calculateMarginalRevenueByMarket();
        
        //********************************************************Question 5
        optimizePriceRanges();
        
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.println("Reading data from CSV files: ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        // Call the readCSV method
        readCSV(
        "orders.csv",
        "useraccounts.csv",
        "customers.csv",
        "salesperson.csv",
        "suppliers.csv"
    );
         
     // processOrdersAndPrintResults();
    }
    
    private static double calculateTotalSalesRevenue(SalesPersonProfile salesperson) {
    //System.out.println("Calculating total sales revenue for salesperson: " + salesperson.getPerson().getPersonId());

    double totalRevenue = 0.0;

    for (Order order : salesperson.getSalesorders()) {
       // System.out.println("Order ID: " + order.getOrderID() + ", Total Revenue: " + order.calculateTotalRevenue());
        totalRevenue += order.calculateTotalRevenue();
    }

    //System.out.println("Total Sales Revenue for salesperson: " + salesperson.getPerson().getPersonId() + ": " + totalRevenue);

    return totalRevenue;
}


    public void insert(JPanel jpanel) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SplitHomeArea = new javax.swing.JSplitPane();
        actionsidejpanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UserNameTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CardSequencePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        actionsidejpanel.setBackground(new java.awt.Color(0, 153, 153));
        actionsidejpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        actionsidejpanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 30));

        jLabel1.setText("User Name");
        actionsidejpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        UserNameTextField.setText("sales");
        actionsidejpanel.add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        PasswordTextField.setText("XXXX");
        actionsidejpanel.add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        jLabel2.setText("Password");
        actionsidejpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        SplitHomeArea.setLeftComponent(actionsidejpanel);

        CardSequencePanel.setLayout(new java.awt.CardLayout());
        SplitHomeArea.setRightComponent(CardSequencePanel);

        getContentPane().add(SplitHomeArea, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        //      WorkAreaJPanel ura = new WorkAreaJPanel(workareajpanl);

        String un = UserNameTextField.getText();
        String pw = PasswordTextField.getText();

        UserAccountDirectory uad = business.getUserAccountDirectory();
        UserAccount useraccount = uad.AuthenticateUser(un, pw);
        if (useraccount == null) {
            return;
        }
        SalesPersonWorkAreaJPanel salesworkarea;
        MarketingManagerWorkAreaJPanel1 marketingworkarea;
        BusinessManagerWorkAreaJPanel bzmanagerworkarea;
        String r = useraccount.getRole();
        Profile profile = useraccount.getAssociatedPersonProfile();
        //       if (r.equalsIgnoreCase("sales")) {
        
        if (profile instanceof SalesPersonProfile) {

            SalesPersonProfile spp = (SalesPersonProfile) profile;
            //displayquestion1();
           // displayquestion2();
            salesworkarea = new SalesPersonWorkAreaJPanel(business, spp, CardSequencePanel);
            CardSequencePanel.removeAll();
            CardSequencePanel.add("Sales", salesworkarea);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        }

        if (profile instanceof MarketingPersonProfile) {
            marketingworkarea = new MarketingManagerWorkAreaJPanel1(business, CardSequencePanel);
            CardSequencePanel.removeAll();
            CardSequencePanel.add("Marketing", marketingworkarea);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        }

        if (profile instanceof EmployeeProfile) {

            bzmanagerworkarea = new BusinessManagerWorkAreaJPanel(business, CardSequencePanel);
            CardSequencePanel.removeAll();
            CardSequencePanel.add("Admin", bzmanagerworkarea);
            ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        }

    }//GEN-LAST:event_LoginButtonActionPerformed

    public void readCSV(String orderscsvFilePath, String userAccountscsvFilePath, String customerscsvFilePath, String salespersoncsvFilePath, String supplierscsvFilePath) {
    // Process each CSV file path
    processCSV(orderscsvFilePath);
    processCSV(userAccountscsvFilePath);
    processCSV(customerscsvFilePath);
    processCSV(salespersoncsvFilePath);
    processCSV(supplierscsvFilePath);
}

private void processCSV(String csvFilePath) {
    try {
        // Extract the filename from the path
        String filename = csvFilePath.substring(csvFilePath.lastIndexOf('/') + 1);

        // Create a BufferedReader to read the CSV file
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));

        // Read and print each line from the CSV file with the "CSV data - filename" prefix
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("CSV data - " + filename + ": " + line);
        }

        // Close the reader
        reader.close();
    } catch (FileNotFoundException e) {
        System.out.println("The file was not found: " + csvFilePath);
    } catch (IOException e) {
        System.out.println("An error occurred while reading the file: " + csvFilePath);
        e.printStackTrace();
    }
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PricingMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PricingMainFrame().setVisible(true);
            }
        });
        
  
        
        //PricingMainFrame m = new PricingMainFrame();
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardSequencePanel;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JSplitPane SplitHomeArea;
    private javax.swing.JTextField UserNameTextField;
    private javax.swing.JPanel actionsidejpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
