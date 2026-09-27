import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws Exception {

      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver Loaded successfully...");
      
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","punamW19@");
      System.out.println("Connection established...");
      
      Statement stmt = conn.createStatement();
      
      int affectedRows = stmt.executeUpdate("insert into users(email,name,password) values('vaibhavw2001@gmail.com','Vaibhav Wagh','vaibhav19@')");
      
      if(affectedRows>0) {
    	  System.out.println("Record inserted successfully.");
      }
      else {
    	  System.out.print("Insertion failed.");
      }
      stmt.close();
      conn.close();
      
	}

}
