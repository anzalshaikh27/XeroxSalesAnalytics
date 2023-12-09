/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    int price;//floor, ceiling, and target ideas
    String ad;
    MarketChannelAssignment marketchannelcomb;
    ArrayList<SolutionOrder> solutionorders;
    
    public SolutionOffer(MarketChannelAssignment m){
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        m.addSolutionOffer(this); 
       
    } 
    
    public void addProduct(Product p){
        products.add(p);
    }
    public void setTotalPrice(int p){
        price = p;
        
    }
    public int getSolutionPrice(){
        return price;
    }
    
    public int getRevenues(){
        int sum = 0;
        for(SolutionOrder so: solutionorders){
            sum = sum + so.getSolutionPrice();
            
        }
        return sum;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MarketChannelAssignment getMarketchannelcomb() {
        return marketchannelcomb;
    }

    public void setMarketchannelcomb(MarketChannelAssignment marketchannelcomb) {
        this.marketchannelcomb = marketchannelcomb;
    }

    public ArrayList<SolutionOrder> getSolutionorders() {
        return solutionorders;
    }

    public void setSolutionorders(ArrayList<SolutionOrder> solutionorders) {
        this.solutionorders = solutionorders;
    }
    
    public void addSolutionOrder(SolutionOrder so){
        solutionorders.add(so);
    }
    // this will allow one to retrieve all offers meant for this market/channel combo
    public boolean isSolutionOfferMatchMarketChannel(MarketChannelAssignment mca){
        
        if (marketchannelcomb==mca) return true;
        else return false;
    }
    public String getAd(){
        return ad;
    }
    public void setAd(String a){ //this an amazing solution for people like
        ad = a;
    }

    public int getTotalPrice() {
        // Implement the logic to calculate the total price of the solution offer
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getProductPrice();
        }
        return totalPrice;
    }
    
    public String getDescription() {
        // Implement the logic to generate a description based on the products and ad.
        StringBuilder description = new StringBuilder();
        description.append("Products: ");
        for (Product product : products) {
            description.append(product.getProductName()).append(", ");
        }

        // Append "Ad" information only if it's not null
        if (ad != null) {
            description.append("\nAd: ").append(ad);
        }

        return description.toString();
    }
    
}
