
import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5;
	JLabel l1,l2,l3;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	JPanel p1,p2,p3,p4;
	public Login() {
		super("Login Page");
		l1 = new JLabel("Username: ");
		l2 = new JLabel("Password: ");
		t1 = new JTextField(20);
		t2 = new JPasswordField(20);
		
		b1 = new JButton("Login");
		
		b2 = new JButton("Cancel");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icons/pop.jpg"));
		Image i3 = ic3.getImage().getScaledInstance(180, 300, Image.SCALE_DEFAULT);
		ic3 = new ImageIcon(i3);
		l3 = new JLabel(ic3);
		setLayout(new BorderLayout());
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		this.add(l3,BorderLayout.WEST);
		p2.add(l1);
		p2.add(t1);
		p2.add(l2);
		p2.add(t2);
		add(p2,BorderLayout.CENTER);
		
		p4.add(b1);
		p4.add(b2);
		p4.setBorder(new EmptyBorder(0, 200, 0, 10));
		add(p4,BorderLayout.SOUTH);
		setResizable(false);
		setSize(500,250);
		setLocation(400,300);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Conn c1 = new Conn();
			String s1 = t1.getText();
			String s2 = String.valueOf(t2.getPassword());
//			System.out.println(s2);
			String q = "SELECT * FROM login WHERE username = '"+s1+"' and pass = '"+s2+"';";
			ResultSet rs = c1.s.executeQuery(q);
			if(rs.next()) {
				new Project().setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Login");
				setVisible(false);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("Error: "+e2);
		}
		
	}

}
