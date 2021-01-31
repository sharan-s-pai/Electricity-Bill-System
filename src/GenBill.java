import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class GenBill extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	JLabel l1,l2;
	JTextArea ta1;
	JButton b1;
	JTextField tf1;
	Choice c1;
	JPanel p1;
	public GenBill() {
		setSize(560,700);
		setLayout(new BorderLayout());
		
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		l1 = new JLabel("Grenerate Bill for : ");
		
		l2 = new JLabel("Enter the Meter No.");
		tf1 = new JTextField(10);
		c1 = new Choice();
		c1.add("January");
		c1.add("February");
		c1.add("March");
		c1.add("April");
		c1.add("May");
		c1.add("June");
		c1.add("July");
		c1.add("August");
		c1.add("September");
		c1.add("October");
		c1.add("November");
		c1.add("December");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ta1 = new JTextArea(50,20);
		JScrollPane sp1 = new JScrollPane(ta1);
		l1.setFont(new Font("TimesRoman",Font.BOLD,16));
		
		b1 = new JButton("Generate Bill");
		
		p1.add(l1);
		p1.add(l2);
		p1.add(tf1);
		p1.add(c1);
		this.add(p1,BorderLayout.NORTH);
		
		this.add(sp1,BorderLayout.CENTER);
		add(b1,BorderLayout.SOUTH);
		
		b1.addActionListener(this);
		
		this.getContentPane().setBackground(Color.white);
		
		setVisible(false);
	}

	public static void main(String[] args) {
		new GenBill().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Conn c = new Conn();
			
			String month = c1.getSelectedItem();
			ta1.setText("\tABC Power Limited\n\tELECTRICITY BILL\n\t"+month+"2021\n\n\n");
			String meterNo = tf1.getText();
			ResultSet r = c.s.executeQuery("SELECT * FROM customers WHERE MeterNo='"+meterNo+"';");
			if(r.next()) {
				ta1.append("\n   Customer Name: "+r.getString("Name"));
				ta1.append("\n   Meter No.: "+r.getString("MeterNo"));
				ta1.append("\n   Address: "+r.getString("Address"));
				ta1.append("\n   City: "+r.getString("City"));
				ta1.append("\n   State: "+r.getString("State"));
				ta1.append("\n   Phone No.: "+r.getString("PhoneNo"));
				ta1.append("\n--------------------------------------------------------------\n");
			}else {
				JOptionPane.showMessageDialog(this, "Enterred Customer meter no. not in register. Add the customer.");
				return;
			}
			r = c.s.executeQuery("SELECT * FROM tax;");
			if(r.next()) {
				ta1.append("\n   Meter Location:  "+r.getString("MeterLocation"));
				ta1.append("\n   Meter Type:\t"+r.getString("MeterType"));
				ta1.append("\n   Bill Type:\t"+r.getString("BillType"));
				ta1.append("\n   Days:\t"+r.getString("Days"));
				ta1.append("\n--------------------------------------------------------------\n");
				ta1.append("\n   Meter Rent:\t"+r.getString("MeterRent"));
				ta1.append("\n   Service Tax:\t"+r.getString("ServiceTax"));
				ta1.append("\n   GST:\t"+r.getString("GST"));
			}
			r = c.s.executeQuery("SELECT * FROM bill WHERE MeterNumber='"+meterNo+"'AND Month='"+month+"';");
			if(r.next()) {
				if(r.getString("payStatus").equals("NOT PAID")){
					ta1.append("\n   Current Month:\t"+r.getString("Month"));
					ta1.append("\n   Unit Consumed:\t"+r.getString("UnitsConsumed"));
					ta1.append("\n   Total Charges:\t"+r.getString("paymentAmount"));
					ta1.append("\n--------------------------------------------------------------\n");
					ta1.append("\n    TOTAL PAYABLE:\t"+r.getString("paymentAmount"));
				}
				//System.out.println(ta1.getText());
			}else {
				JOptionPane.showMessageDialog(this, meterNo+" has PAID his bill for the month of "+month);
			}
			ta1.setFont(new Font("TimesRoman",Font.BOLD,18));
			//revalidate();
		} catch (Exception e2) {
			System.out.println(e2);
		}
		
	}
	public Insets getInsets() {
		return new Insets(50,20,20,20);
		
	}
}
