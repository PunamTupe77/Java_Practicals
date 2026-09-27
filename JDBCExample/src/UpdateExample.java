import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExample {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded successfully.");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","punamW19@");
		System.out.println("Connection established.");
		
		Statement stmt = conn.createStatement();
		
		int affectedRows = stmt.executeUpdate("update users set email='vaibhavwagh2001@gmail.com' where name='Vaibhav wagh'");
		
		if(affectedRows>0) {
			System.out.println("Record updated successfully.");
		}
		else {
			System.out.println("Failed to update.");
		}
		stmt.close();
		conn.close();
	}

}
