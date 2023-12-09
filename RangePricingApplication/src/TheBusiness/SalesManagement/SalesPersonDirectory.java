/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SalesManagement;

import TheBusiness.Business.Business;
import java.util.ArrayList;
import TheBusiness.Personnel.Person;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author kal bugrara
 */
public class SalesPersonDirectory {

    Business business;
    
   private ArrayList<SalesPersonProfile> salespersonlist;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public ArrayList<SalesPersonProfile> getSalespersonlist() {
        return salespersonlist;
    }

    
    // Add this method to calculate sales performance for each salesperson
    public void calculateSalesPerformance() {
        for (SalesPersonProfile sp : salespersonlist) {
            sp.calculateSalesPerformance();
        }
    }

    // Add this method to get the top N salespeople
    public ArrayList<SalesPersonProfile> getTopSalesPeople(int n) {
        calculateSalesPerformance();

        // Sort the salespeople based on sales performance
        Collections.sort(salespersonlist, Comparator.comparingDouble(SalesPersonProfile::getSalesPerformance).reversed());

        // Get the top N salespeople
        ArrayList<SalesPersonProfile> topSalesPeople = new ArrayList<>(salespersonlist.subList(0, Math.min(n, salespersonlist.size())));

        return topSalesPeople;
    }
    
    
    public void setSalespersonlist(ArrayList<SalesPersonProfile> salespersonlist) {
        this.salespersonlist = salespersonlist;
    }
    

    public SalesPersonDirectory(Business d) {

        business = d;
        salespersonlist = new ArrayList();

    }

    public SalesPersonProfile newSalesPersonProfile(Person p) {

        SalesPersonProfile sp = new SalesPersonProfile(p);
        salespersonlist.add(sp);
        return sp;
    }

    public SalesPersonProfile findSalesPerson(String id) {

        for (SalesPersonProfile sp : salespersonlist) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }

}
