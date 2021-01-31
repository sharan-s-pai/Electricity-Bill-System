import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
@SuppressWarnings("unused")
public class PayBill extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1;
	Choice c1;
	JButton b1,b2;
	JPanel p;
	public PayBill() {
		setVisible(false);
		setSize(1000,600);
		p = new JPanel();
		p.setLayout(new GridLayout(4,2,30,30));
		p.setBackground(Color.WHITE);
		
		l1 = new JLabel("Pay Electricity Bill");
		l1.setFont(new Font("TimesRoman",Font.BOLD,18));
		l1.setBorder(new EmptyBorder(10,360,0,10));
		l2 = new JLabel("Meter No.");
		l4 = new JLabel("Month");
		
		t1 = new JTextField();
		
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
		
		b1 = new JButton("Paid");
		b2 = new JButton("Cancel");
		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payBill.jpg"));
		Image i = i1.getImage().getScaledInstance(240,270, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i);
		
		l5 = new JLabel(i1);
		p.add(l2);
		p.add(t1);
		p.add(l4);
		p.add(c1);
		p.add(b1);
		p.add(b2);
		this.getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout(30,30));
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(l1,"North");
		add(p,"Center");
		add(l5,"East");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PayBill().setVisible(true);

	}
	public Insets getInsets() {
		return new Insets(40, 20, 20, 50);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if(msg.equals("Paid")) {
			String s1 = t1.getText();
			String s2 = c1.getSelectedItem();
			if(s1.equals("")) {
				JOptionPane.showMessageDialog(this, "Kindly enter the Meter Number");
				return;
			}
			try {
				Conn cc = new Conn();
				String q1 = "SELECT * FROM bill WHERE MeterNumber='"+s1+"' AND Month='"+s2+"';";
				ResultSet rs1 = cc.s.executeQuery(q1);
				String amount;
				if(rs1.next()) {
					amount = rs1.getString("paymentAmount");
				}else {
					JOptionPane.showMessageDialog(this, "Bill for Meter Number: "+s1+" for month "+s2+" has already been cleared.");
					this.setVisible(false);
					return;
				}
				String q = "DELETE FROM bill WHERE MeterNumber='"+s1+"' AND Month='"+s2+"';";
				int val = cc.s.executeUpdate(q);
				if(val!=0)
					JOptionPane.showMessageDialog(this, "Bill for Meter Number: "+s1+" for month "+s2+" has been paid. Amount paid = "+amount);
				this.setVisible(false);
			}catch(Exception e1) {
				System.out.println(e1);
			}
		}
		
	}

}
