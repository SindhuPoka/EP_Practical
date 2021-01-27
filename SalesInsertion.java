package klu.sinsertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import klu.bean.SupermarketBean;
import klu.connections.DBUtil;

public class SalesInsertion {
	Scanner s = new Scanner(System.in);
	   public int SalesInsert(SupermarketBean sales) throws ClassNotFoundException,SQLException{
	     Connection con=DBUtil.DBConnection();
	       PreparedStatement ps=con.prepareStatement("insert into sales values(?,?,?)"); 
	       ps.setInt(1,sales.getItemid());
	       ps.setString(2,sales.getItemname());
	       ps.setDouble(3,sales.getCost());
	       int i = ps.executeUpdate();
	       return i;
	     }
	   public void SalesDisplay(SupermarketBean sales)throws ClassNotFoundException, SQLException
	     {
	       Connection con=DBUtil.DBConnection();
	       PreparedStatement stmt=con.prepareStatement("select * from sales");  
	       ResultSet rs=stmt.executeQuery();  
	       while(rs.next()){  
	       System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));  
	       }  
		  
	  }
	   public void displayCost(SupermarketBean sales)throws ClassNotFoundException, SQLException
		{
			int sum=0;
			Connection con=DBUtil.DBConnection();
			Statement st = con.createStatement();
		    ResultSet res = st.executeQuery("SELECT SUM(cost) FROM sales");
		    while (res.next()) {
		      int c = res.getInt(1);
		      sum = sum + c;
		    }
		    System.out.println("total cost  = " + sum); 
		}
	   
	  
}

