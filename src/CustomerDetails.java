import javax.swing.*;
import java.awt.*;
import java.sql.*;

@SuppressWarnings("unused")
public class CustomerDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3;
	JTable t1;
	JButton b1;
	String[] s = {"Name","Meter No.","Address","State","City","Phone No"};
	String[][] customer = new String[20][7]; 
	int i=0,j=0;
	public CustomerDetails() {
		super("Customer Details");
		setSize(1200,650);
		setLocation(50,50);
		setVisible(false);
		try {
			Conn c1 = new Conn();
			String s1 = "SELECT * FROM customers;";
			ResultSet r1 = c1.s.executeQuery(s1);
			while(r1.next()) {
				customer[i][j++] = r1.getString("Name");
				customer[i][j++] = r1.getString("MeterNo");
				customer[i][j++] = r1.getString("Address");
				customer[i][j++] = r1.getString("State");
				customer[i][j++] = r1.getString("City");
				customer[i][j++] = r1.getString("PhoneNo");
				j=0;
				i++;
			}
			
			t1 = new JTable(customer,s);
			
		}catch(Exception e1) {
			System.out.println(e1);
		}
		JScrollPane sp  = new JScrollPane(t1);
		this.add(sp);
	}

	public static void main(String[] args) {
		new CustomerDetails().setVisible(true);

	}

}
