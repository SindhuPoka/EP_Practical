import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	  final static String forNameURL="com.mysql.cj.jdbc.Driver";
	  final static String dBURL="jdbc:mysql://localhost:3306/epskill";
	  final static String username="root";
	  final static String password="root";
	  public static Connection DBConnection() throws SQLException,ClassNotFoundException{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection(dBURL,username,password);
		  return con;
	  }

}
