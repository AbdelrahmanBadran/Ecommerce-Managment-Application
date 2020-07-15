/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.util.Arrays;
import javax.swing.JTable;

/**
 * 
 * @author AbdelRahman Badran , Madoma Diallo 
 */
public class NonFragileShipping extends  Shipping{
     private String [ ] closeRegions = {"Kuala Lumpur","Seberang","Perai","Kajang","Klang"};
    private String[] farRegions = {"Subang Jaya","Ipoh","Shah Alam","Seremban","Johor Bahru"};
    private final double nonFragileProductShippingCost = 2.5;

    @Override
    public double calculateShippingCost(JTable table, String address) {
         double packagingPrice = 0.00;
        for(int rowCount = 0; rowCount < table.getRowCount(); rowCount++) {
            String packagingType = table.getValueAt(rowCount, 3).toString();
             if(packagingType.equals("Non-Fragile")){
            packagingPrice += nonFragileProductShippingCost;
             }
        }
        if(Arrays.stream(closeRegions).anyMatch(address ::equals) ) {
                packagingPrice += 1.0;
            }
          else if (Arrays.stream(farRegions).anyMatch(address ::equals)){
              packagingPrice += 1.5;
          }
        return packagingPrice;
    }
    

}
