import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///electricitymanagement","root","1BM19CS146");
			s = c.createStatement();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
