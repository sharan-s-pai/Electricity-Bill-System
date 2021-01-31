import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NewCustomer extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2;
	public NewCustomer() {
		setSize(650,600);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(9,2,10,10));
		
		l1 = new JLabel("Name:");
		t1 = new JTextField();
		p.add(l1);
		p.add(t1);
		l2 = new JLabel("Meter No.:");
		t2 = new JTextField();
		p.add(l2);
		p.add(t2);
		l3 = new JLabel("Address:");
		t3 = new JTextField();
		p.add(l3);
		p.add(t3);
		l4 = new JLabel("State:");
		t4 = new JTextField();
		p.add(l4);
		p.add(t4);
		l5 = new JLabel("City:");
		t5 = new JTextField();
		p.add(l5);
		p.add(t5);
		l6 = new JLabel("Phone Number: ");
		t6 = new JTextField();
		p.add(l6);
		p.add(t6);
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		
		b1.setBackground(Color.black);
		b2.setBackground(Color.black);
		
		b1.setForeground(Color.white);
		b2.setForeground(Color.white);
		p.setBackground(Color.WHITE);
		ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
		Image i3 = ic1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ic1 = new ImageIcon(i3);
		l7 = new JLabel(ic1);
		l8 = new JLabel("Customer Registration");
		l8.setFont(new Font("TimesRoman",Font.BOLD,19));
		l8.setBorder(new EmptyBorder(20,270,20,20));
		p.add(b1);
		p.add(b2);
		this.setLayout(new BorderLayout());
		this.add(l8,BorderLayout.NORTH);
		//l8.setVerticalAlignment(200);
		this.add(p,BorderLayout.CENTER);
		this.add(l7,BorderLayout.WEST);
		this.getContentPane().setBackground(Color.WHITE);
		setVisible(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		this.setResizable(false);
	}
	
	public Insets getInsets() {
		return new Insets(40,0, 20, 50);
	}

	public static void main(String[] args) {
		new NewCustomer().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Submit")) {
			String s1 = t1.getText();
			String s2 = t2.getText();
			String s3 = t3.getText();
			String s4 = t4.getText();
			String s5 = t5.getText();
			String s6 = t6.getText();
			if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")||s6.equals("")) {
				JOptionPane.showMessageDialog(this, "Enter all fields to submit");
			}else {
				String q1 = "INSERT INTO customers(Name,MeterNo,Address,State,City,PhoneNo) VALUES ('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"');";
				try {
					Conn c1 = new Conn();
					c1.s.executeUpdate(q1);
					JOptionPane.showMessageDialog(this, "New Customer added");
					this.setVisible(false);
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		}else {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
		}
	}

}
