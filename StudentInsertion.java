package klu.insert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import klu.connections.DBUtil;
import klu.bean.studentbean;
public class StudentInsertion {
	Scanner s = new Scanner(System.in);
   public int StudentInsert(studentbean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)"); 
	   ps.setInt(1,student.getRegno());
	   ps.setString(2,student.getName());
	   ps.setString(3,student.getEmail());
	   int i = ps.executeUpdate();
	   return i;
   }
   public int StudentDelete(studentbean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   System.out.println("enter the regno of student  to be deleted:");
	   int regno=s.nextInt();
	   PreparedStatement stmt=con.prepareStatement("delete from student where regno=?");  
	   stmt.setInt(1,regno);  
	   int i=stmt.executeUpdate();  
	   return i;
   }
   public int StudentUpdate(studentbean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   System.out.println("enter the regno of student whose name to be updated:");
	   int regno=s.nextInt();
	   System.out.println("enter the name to which it has to be updated:");
	   String name=s.next();
	   PreparedStatement stmt=con.prepareStatement("update student set name=? where regno=?");  
	   stmt.setString(1,name);//1 specifies the first parameter in the query i.e. name  
	   stmt.setInt(2,regno);  
	     
	   int i=stmt.executeUpdate();  
	   return i;
   }
   public void StudentDisplay(studentbean student)throws ClassNotFoundException, SQLException
   {
	   Connection con=DBUtil.DBConnection();
	   PreparedStatement stmt=con.prepareStatement("select * from student");  
	   ResultSet rs=stmt.executeQuery();  
	   while(rs.next()){  
	   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));  
	   }  
	   
   }
   
   
   
}
