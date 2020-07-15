package Controller;

import javax.swing.JTable;

public interface Payment {
	
    abstract public double calculateOrderGrandTotal(JTable table, double shippingFee);

}
