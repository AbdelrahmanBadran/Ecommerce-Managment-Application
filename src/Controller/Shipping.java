package Controller;

import javax.swing.JTable;

public abstract class Shipping {
    
    abstract public double calculateShippingCost(JTable table, String address);
}

//was used in main page as a normal method but now made as an abstract
//    public double calculateShippingCost(){
//        double packagingPrice = 0.00;
//        for(int rowCount = 0; rowCount < cartTable.getRowCount(); rowCount++) {
//            String packagingType = cartTable.getValueAt(rowCount, 3).toString();
//            switch (packagingType){
//               case "Fragile": packagingPrice += 3.5;
//                                            break;
//               case "Non-Fragile": packagingPrice+= 2.5;
//
//           }
//        }
//        return packagingPrice;
//    }
