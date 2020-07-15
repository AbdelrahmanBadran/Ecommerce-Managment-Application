package Controller;

import javax.swing.JTable;

public class Total implements Payment{

    @Override
    public double calculateOrderGrandTotal(JTable table, double shippingFee) {
         double orderTotal = 0.00;
        for(int rowCount = 0; rowCount < table.getRowCount(); rowCount++) {
              double subTotal = Double.parseDouble(table.getValueAt(rowCount, 4).toString());
              orderTotal += subTotal;
        }
        orderTotal+=shippingFee;
           return orderTotal;
    }
    public double calculateSubTotal(double price ,int quantity){
        double subTotal = price * quantity;
        return subTotal;
    }

}
