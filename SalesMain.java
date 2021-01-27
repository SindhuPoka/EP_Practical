package klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import klu.bean.SupermarketBean;
import klu.sinsertion.SalesInsertion;

public class SalesMain {
	public static void main(String args[]) throws ClassNotFoundException,SQLException{
		Scanner sc=new Scanner(System.in);
		  SupermarketBean sb = new SupermarketBean();
		    SalesInsertion si = new  SalesInsertion();
		    while(true) {
		        System.out.println("\n1.Insert  \n2.Display the Details \n3.Total Cost");
		        int ch = sc.nextInt();
		      switch(ch) {
		      case 1:
		          System.out.println("enter itemid,itemname,cost");
		          int itemid=sc.nextInt();
		          String itemname=sc.next();
		          double cost=sc.nextDouble();
		          
		          sb.setItemid(itemid);
		          sb.setItemname(itemname);
		          sb.setCost(cost);
		          int i=si.SalesInsert(sb);
		          if(i>0)
		            System.out.println("Insertion is successfull");
		          else
		            System.out.println("fail");
		          break;
		      case 2:
		          si.SalesDisplay(sb);
		          break;
		      case 3:
		    	  si.displayCost(sb);
		    	  break;
		      case 4:
		    	  break;
		    	  
		      }
	}

}
}
