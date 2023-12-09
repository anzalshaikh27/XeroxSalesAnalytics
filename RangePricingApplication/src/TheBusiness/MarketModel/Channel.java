/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {
    String channeltype; //tv, internet, mobile app..
    public Channel(String t){
        channeltype = t;
    }
    
//    public Channel(){
//        
//    }
    
    public boolean isMatch(String t){
        if (channeltype.equalsIgnoreCase(t))return true;
        else return false;
    }

    public String getChanneltype() {
        return channeltype;
    }

    public void setChanneltype(String channeltype) {
        this.channeltype = channeltype;
    }
    public String getChannelType( ){
        return channeltype;
    }
}
