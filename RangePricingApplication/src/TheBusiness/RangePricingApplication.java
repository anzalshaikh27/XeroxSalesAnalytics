/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness;

import TheBusiness.Business.Business;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Business business = ConfigureABusiness.initializeMarkets();
     
       
       // Retrieve the MasterSolutionOrderList from the business
        MasterSolutionOrderList masterSolutionOrderList = business.getMasterSolutionOrderList();

        // Iterate over each market and channel combination
        for (Market market : business.getMarketCatalog().getMarkets()) {
            for (Channel channel : business.getChannelCatalog().getChannels()) {
                // Retrieve the corresponding MarketChannelCombo
                MarketChannelAssignment marketChannelCombo = business.getMarketChannelComboCatalog()
                        .finMarketChannelCombo(market, channel);
                
                // Retrieve the negotiated solutions for the given MarketChannelCombo
                List<SolutionOffer> negotiatedSolutions = masterSolutionOrderList.getNegotiatedSolutions(marketChannelCombo);
                
                // Sort the negotiated solutions based on performance (e.g., revenue generated)
                negotiatedSolutions.sort(Comparator.comparingInt(SolutionOffer::getTotalPrice).reversed());
                
                // Display the information in a systematic way
                System.out.println("Market: " + market.getName() + ", Channel: " + channel.getChannelType());
                System.out.println("Negotiated Solutions Size: " + negotiatedSolutions.size());

                // Display or store the top 3 negotiated solutions for each market segment
                System.out.println("Top 3 Negotiated Solutions for " + market.getName() + " and Channel " + channel.getChannelType());

                int count = 0;
                for (SolutionOffer solutionOffer : negotiatedSolutions) {
                    System.out.println("Solution: " + solutionOffer.getDescription() + ", Revenue: " + solutionOffer.getTotalPrice());
                                     
                    System.out.println();
                    count++;
                    if (count > 6) {
                        break; // Displaying only the top 3 solutions
                        
                    }
                }
            }
        }
       
       
    }

}

