import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteExample {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded.");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","punamW19@");	
		System.out.println("Connection established.");
		
		Statement stmt = conn.createStatement();
		int affectedRows = stmt.executeUpdate("delete from users where name='Vaibhav Wagh'");
		if(affectedRows>0) {
			System.out.println("Record deleted successfully." +affectedRows);
		}
		else {
			System.out.println("Failed to delete record.");
		}
		stmt.close();
		conn.close();
	}

}
