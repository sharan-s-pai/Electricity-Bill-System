import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
@SuppressWarnings("unused")
public class CalBill extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2;
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2;
	Choice c1;
	JButton b1,b2;
	JPanel p;
	public CalBill() {
		setVisible(false);
		setSize(1000,600);
		p = new JPanel();
		p.setLayout(new GridLayout(4,2,30,30));
		p.setBackground(Color.WHITE);
		
		l1 = new JLabel("Calculate Electricity Bill");
		l1.setFont(new Font("TimesRoman",Font.BOLD,18));
		l1.setBorder(new EmptyBorder(10,360,0,10));
		l2 = new JLabel("Meter No.");
		l3 = new JLabel("Units Consumed");
		l4 = new JLabel("Month");
		
		t1 = new JTextField();
		t2 = new JTextField();
		
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
		
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/calB.jpg"));
		Image i = i1.getImage().getScaledInstance(240,270, Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i);
		
		l5 = new JLabel(i1);
		
		p.add(l2);
		p.add(t1);
		p.add(l3);
		p.add(t2);
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
	
	public Insets getInsets() {
		return new Insets(40, 20, 20, 50);
	}
	
	public static void main(String[] args) {
		new CalBill().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Submit")) {
			String s1 = t1.getText();
			String s2 = t2.getText();
			String s3 = c1.getSelectedItem();
			if(s1.equals("")||s2.equals("")) {
				JOptionPane.showMessageDialog(this, "All Fields have to be filled");
			}else {
				try {
					int p1 = Integer.parseInt(s2);
					int p2=p1*7;
					double p3=p2+(50+(0.18*p2)+(0.05*p2));
					String s5 = Double.toString(p3);
					String q = "INSERT INTO bill(MeterNumber,UnitsConsumed,Month,paymentAmount,payStatus) VALUES('"+s1+"','"+s2+"','"+s3+"','"+s5+"','NOT PAID');";
//					System.out.println(q);
					try {
						Conn c1 = new Conn();
						c1.s.executeUpdate(q);
						JOptionPane.showMessageDialog(this, "Bill is Updated");
						t1.setText("");
						t2.setText("");
						this.c1.select(0);
					} catch (Exception e2) {
						System.out.println(e2);
					}
					
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(this, "Enter only number in no. of units consumed field");
				}
			}
		}else {
			t1.setText("");
			t2.setText("");
			c1.select(0);
		}
	}
}
