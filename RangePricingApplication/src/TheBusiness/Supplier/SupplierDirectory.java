/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Supplier;

import TheBusiness.ProductManagement.ProductCatalog;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SupplierDirectory {
    ArrayList<Supplier> suppliers;
    public SupplierDirectory(){
        suppliers = new ArrayList();
    }
    public Supplier newSupplier(String n){
        Supplier supplier = new Supplier(n);
        suppliers.add(supplier);
        return supplier;

    }
    public Supplier findSupplier(String id){
        
        for (Supplier supplier: suppliers){
            
            if(supplier.getName().equals(id)) return supplier;
        }
        return null;
        }
    
    public void removeSupplier(Supplier s) {
        suppliers.remove(s);
    }

    public ArrayList<Supplier> getSuplierList(){
        return suppliers;
    }
    
     public ProductCatalog getProductCatalog(Supplier supplier) {
        // Find the supplier in the list
        for (Supplier s : suppliers) {
            if (s.equals(supplier)) {
                return s.getProductCatalog();
            }
        }
        return null; // Supplier not found
    }
    
}