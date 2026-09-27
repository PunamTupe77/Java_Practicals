import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectExample {
  
	public static void main(String args[]) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded...");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","punamW19@");
		System.out.println("Connection established....");
		
		Statement statement = connection.createStatement();
		System.out.println("Statement created....");
		
		ResultSet resultSet = statement.executeQuery("select * from users");
		System.out.println("Fetching data from table");
		
		
		while(resultSet.next()) {
			String email = resultSet.getString(1);
			String name = resultSet.getString(2);
			String password = resultSet.getString(3);
			
			System.out.println("Email :" +email);
			System.out.println("Name :" +name);
			System.out.println("password :" +password);
		}
	}
}
