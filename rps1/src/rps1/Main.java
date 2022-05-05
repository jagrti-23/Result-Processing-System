package rps1;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

  static Connection con;

  public static void main(String[] args) {
	// write your code here
    try{
          Class.forName("org.postgresql.Driver");
          con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","chini");
          System.out.println("Connected Successfully!");
          if(con.isClosed()){
              System.out.println("Connection is still closed!");
          }else{
              System.out.println("Connected....");
          }
      }catch(ClassNotFoundException | SQLException e){
          e.printStackTrace();
          System.err.println(e.getClass().getName() + ": "+e.getMessage());
          System.exit(0);
      }

      StudentLogic sl = new StudentLogic();
      sl.setVisible(true);
      sl.setBounds(100,100,700,500);
      sl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}