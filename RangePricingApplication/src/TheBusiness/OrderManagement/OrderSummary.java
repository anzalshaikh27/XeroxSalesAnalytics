/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.OrderManagement;

/**
 *
 * @author kal bugrara
 */
public class OrderSummary {
    Order subjectorder;
    int salesvolume;
    boolean totalabovetarget;
    int orderpriceperformance;
    int numberofOrderitemsabovetarget;
    int numberofOrdeitemsbelowtarget;
    
public OrderSummary(Order o){
    subjectorder = o;
    salesvolume = o.getOrderTotal();
    totalabovetarget = o.isOrderAboveTotalTarget();
    orderpriceperformance = o.getOrderPricePerformance();
    numberofOrderitemsabovetarget = o.getNumberOfOrderItemsAboveTarget();
    //numberofOrdeitemsbelowtarget = o.getNumberOfOrderItemsBelowTarget();
}

public Order getSubjectOrder(){ return subjectorder;}

public int getOrderProfit(){
    return orderpriceperformance;
}

    public Order getSubjectorder() {
        return subjectorder;
    }

    public void setSubjectorder(Order subjectorder) {
        this.subjectorder = subjectorder;
    }

    public int getSalesvolume() {
        return salesvolume;
    }

    public void setSalesvolume(int salesvolume) {
        this.salesvolume = salesvolume;
    }

    public boolean isTotalabovetarget() {
        return totalabovetarget;
    }

    public void setTotalabovetarget(boolean totalabovetarget) {
        this.totalabovetarget = totalabovetarget;
    }

    public int getOrderpriceperformance() {
        return orderpriceperformance;
    }

    public void setOrderpriceperformance(int orderpriceperformance) {
        this.orderpriceperformance = orderpriceperformance;
    }

    public int getNumberofOrderitemsabovetarget() {
        return numberofOrderitemsabovetarget;
    }

    public void setNumberofOrderitemsabovetarget(int numberofOrderitemsabovetarget) {
        this.numberofOrderitemsabovetarget = numberofOrderitemsabovetarget;
    }

    public int getNumberofOrdeitemsbelowtarget() {
        return numberofOrdeitemsbelowtarget;
    }

    public void setNumberofOrdeitemsbelowtarget(int numberofOrdeitemsbelowtarget) {
        this.numberofOrdeitemsbelowtarget = numberofOrdeitemsbelowtarget;
    }

}
