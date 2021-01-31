import java.sql.ResultSet;

import javax.swing.*;

public class PendBill extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 10;
	JTable t1;
	JButton b1;
	String[] s = {"Meter No.","Unit Consumed","Month","Total Amount","Status"};
	String[][] bills = new String[20][5];
	int i=0,j=0;
	public PendBill() {
		super("Pending Bills");
		setSize(1200,650);
		setLocation(50,50);
		setVisible(false);
		try {
			Conn c1 = new Conn();
			String s1 = "SELECT * FROM bill;";
			ResultSet r1 = c1.s.executeQuery(s1);
			while(r1.next()) {
				bills[i][j++] = r1.getString("MeterNumber");
				bills[i][j++] = r1.getString("UnitsConsumed");
				bills[i][j++] = r1.getString("Month");
				bills[i][j++] = r1.getString("paymentAmount");
				bills[i][j++] = r1.getString("payStatus");
				j=0;
				i++;
			}
			
			t1 = new JTable(bills,s);
		}catch(Exception e) {
			
		}
		JScrollPane sp  = new JScrollPane(t1);
		this.add(sp);
	}

	public static void main(String[] args) {
		new PendBill().setVisible(true);

	}

}
