import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Project extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5;
	public Project() {
		super("Electricity Billing system");
		setSize(1200,700);
		this.getContentPane().setBackground(new Color(254,245,183));
		JMenuBar mb = new JMenuBar();
		
		// Making of master menu
		JMenu master =  new JMenu("Master");
		JMenuItem m1 = new JMenuItem("New Customer");
		JMenuItem m2 = new JMenuItem("Customer Details");
		master.setForeground(Color.BLACK);
		
		// New Customer
		
		m1.setFont(new Font("TimesRoman",Font.PLAIN,12));
		// the mnemonic added here will allow us to add a keyboard shortcut to any button with a designated alphabet alloted to it
		m1.setMnemonic('D');
		//The Following function will activate the what must happen once the keyboard short cut is pressed. SetAccelator is specifically for menu items. So than the function can take place without opening the menu.
		m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		//getKeyStroke() will return the key pressed when the modifier (here ctrl is already pressed
		//NOTE: If 'd' is pressed without pressing ctrl it wont work. It is because it is designed to repond to only when 'd' is pressed along with ctrl
		
		/*Meter Details*/
		m2.setFont(new Font("TimesRoman",Font.PLAIN,12));
		m2.setMnemonic('M');
		m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		
		ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icons/customer.jpg"));
		Image i = ic.getImage().getScaledInstance(210,200,Image.SCALE_DEFAULT);
		ic = new ImageIcon(i);
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(200,250));
		p.setBackground(new Color(255,255,255,0));
		JButton btn = new JButton("i",ic);
		btn.setPreferredSize(new Dimension(200,200));
		btn.setMnemonic('A');
		btn.setVerticalTextPosition(JButton.BOTTOM);
		p.add(btn);
		
		JLabel la1 = new JLabel("New Customer");
		la1.setFont(new Font("TimesRoman",Font.BOLD,18));
		p.add(la1);
		p.setBorder(new EmptyBorder(10,10,10,20));
		btn.addActionListener(this);
		m1.addActionListener(this);
		m2.addActionListener(this);
		
		//---Second Column
		
		JMenu user = new JMenu("User");
		JMenuItem u1 = new JMenuItem("Pay Bill");
		JMenuItem u2 = new JMenuItem("Calculate Bill");
		
		/* Pay bill */
		u1.setFont(new Font("TimesRoman",Font.PLAIN,12));
		u1.setMnemonic('P');
		u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		/*Bill Details*/
		u2.setFont(new Font("TimesRoman",Font.PLAIN,12));
		u2.setMnemonic('B');
		u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		/*Last Bill*/
		u1.addActionListener(this);
		u2.addActionListener(this);
		
		ic = new ImageIcon(ClassLoader.getSystemResource("icons/payBill.jpg"));
		i = ic.getImage().getScaledInstance(210,200,Image.SCALE_DEFAULT);
		ic = new ImageIcon(i);
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(200,250));
		p2.setBackground(new Color(255,255,255,0));
		JButton btn2 = new JButton("j",ic);
		btn2.setPreferredSize(new Dimension(200,200));
		btn2.setMnemonic('B');
		btn2.setVerticalTextPosition(JButton.BOTTOM);
		p2.add(btn2);
		JLabel la2 = new JLabel("Pay Bill");
		la2.setFont(new Font("TimesRoman",Font.BOLD,18));
		p2.add(la2);
		p2.setBorder(new EmptyBorder(10,10,10,20));
		btn2.addActionListener(this);
		
		ic = new ImageIcon(ClassLoader.getSystemResource("icons/calB.jpg"));
		i = ic.getImage().getScaledInstance(210,200,Image.SCALE_DEFAULT);
		ic = new ImageIcon(i);
		JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(200,250));
		p4.setBackground(new Color(255,255,255,0));
		JButton btn4 = new JButton("l",ic);
		btn4.setPreferredSize(new Dimension(200,200));
		btn4.setMnemonic('D');
		btn4.setVerticalTextPosition(JButton.BOTTOM);
		p4.add(btn4);
		JLabel la4 = new JLabel("Calculate Bill");
		la4.setFont(new Font("TimesRoman",Font.BOLD,18));
		p4.add(la4);
		p4.setBorder(new EmptyBorder(10,20,10,10));
		btn4.addActionListener(this);
		
		
		//-----------------------------------------------------------------------
		
		JMenu report = new JMenu("Report");
		JMenuItem r1 = new JMenuItem("Generate Bill");
		JMenuItem r2 = new JMenuItem("Pending Bills");
		/* Generate Bill */
		
		r1.setFont(new Font("TimesRoman",Font.PLAIN,12));
		r1.setMnemonic('G');
		r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		r1.addActionListener(this);
		
		r2.setFont(new Font("TimesRoman",Font.PLAIN,12));
		r2.setMnemonic('H');
		r2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		r2.addActionListener(this);
		
		ic = new ImageIcon(ClassLoader.getSystemResource("icons/bill.jpg"));
		i = ic.getImage().getScaledInstance(210,210,Image.SCALE_DEFAULT);
		ic = new ImageIcon(i);
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(200,250));
		p3.setBackground(new Color(255,255,255,0));
		JButton btn3 = new JButton("k",ic);
		btn3.setPreferredSize(new Dimension(200,200));
		btn3.setMnemonic('C');
		btn3.setBackground(new Color(254,245,183,255));
		btn3.setVerticalTextPosition(JButton.BOTTOM);
		p3.add(btn3);
		JLabel la3 = new JLabel("Generate Bill");
		la3.setFont(new Font("TimesRoman",Font.BOLD,18));
		p3.add(la3);
		p3.setBorder(new EmptyBorder(10,20,10,20));
		btn3.addActionListener(this);
		
		//-----------------------------------------
		
		JMenu exit = new JMenu("Exit");
		JMenuItem e1 = new JMenuItem("Exit");
		
		
		/* Exit */
		e1.setFont(new Font("TimesRoman",Font.PLAIN,12));
		e1.setMnemonic('E');
		e1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		e1.addActionListener(this);
		//----------------------------------------------------------------------
		
		master.add(m1);
		master.add(m2);
		
		user.add(u1);
		user.add(u2);
		
		report.add(r1);
		report.add(r2);
		
		exit.add(e1);
		mb.setBackground(new Color(255,255,255,0));
		mb.add(master);
		mb.add(user);
		mb.add(report);
		mb.add(exit);
		setLayout(new FlowLayout());
		this.setJMenuBar(mb);
		//this.add(btn);
		//btn.addActionListener(this);
		setFont(new Font("TimesRoman",Font.PLAIN,12));
		this.add(p);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		//System.out.println(e);
		if(msg.equals("New Customer")||msg.equals("i")) {
			new NewCustomer().setVisible(true);
			//System.out.println("Hello"+msg);
		}else if(msg.equals("Customer Details")) {
			new CustomerDetails().setVisible(true);
//			System.out.println("Hello"+msg);
		}else if(msg.equals("Pay Bill")||msg.equals("j")) {
			new PayBill().setVisible(true);
//			System.out.println("Hello"+msg);
		}else if(msg.equals("Calculate Bill")||msg.equals("l")) {
			new CalBill().setVisible(true);
//			System.out.println("Hello"+msg);
		}else if(msg.equals("Generate Bill")||msg.equals("k")) {
			new GenBill().setVisible(true);
//			System.out.println("Hello"+msg);
		}else if(msg.equals("Exit")) {
			System.exit(0);
		}else if(msg.equals("Pending Bills")) {
			new PendBill().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Project().setVisible(true);
	}

}
