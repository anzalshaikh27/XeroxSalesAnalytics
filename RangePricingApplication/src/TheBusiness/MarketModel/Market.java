/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Market {

    String name;
    ArrayList<Channel> validchannels;
    ArrayList<String> characteristics; //a way to describe in plain language what is that group
    ArrayList<Market> submarkets;
    int size;

    public Market(String m) {
        name = m;
        characteristics = new ArrayList();
        submarkets = new ArrayList();
        validchannels = new ArrayList();
    }

     public Market() {
        //name = m;
        characteristics = new ArrayList();
        submarkets = new ArrayList();
        validchannels = new ArrayList();
    }
    
    public void addCharactersitic(String c) {
        characteristics.add(c);
    }

    public void addValidChannel(Channel c) {

        validchannels.add(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Channel> getValidchannels() {
        return validchannels;
    }

    public void setValidchannels(ArrayList<Channel> validchannels) {
        this.validchannels = validchannels;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    public ArrayList<Market> getSubmarkets() {
        return submarkets;
    }

    public void setSubmarkets(ArrayList<Market> submarkets) {
        this.submarkets = submarkets;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    

}
