package rps1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.sql.*;

public class UpdateLogic implements ActionListener{
	JFrame frame1;
	JLabel lblERoll;
	JTextField txtEnroll;
	JButton btnRoll;String roll;
	 UpdateLogic(){
	        //set Title of JFrame
	        frame1=new JFrame("Result");
	        frame1.setLayout(null);
	        lblERoll=new JLabel("Enroll No.:");
	        lblERoll.setBounds(20,50,80,30);
	        frame1.add(lblERoll);
	        txtEnroll=new JTextField();
	        txtEnroll.setBounds(120,50,180,30);
	        frame1.add(txtEnroll);
	        btnRoll=new JButton("Submit");
	        btnRoll.setBounds(140,120,80,30);
	        frame1.add(btnRoll);
	        frame1.setBounds(500,400,400,300);
	        frame1.setVisible(true);
	        btnRoll.addActionListener(this);
	    }
	 @Override
	 public void actionPerformed(ActionEvent e){
	    	if(e.getSource()==btnRoll) {
	          this.roll=txtEnroll.getText();
	          try{
	            	int nxtsem=0;
	                Statement stmt = Main.con.createStatement();
	                ResultSet rs2=stmt.executeQuery("select semester from rps.student where enroll_no='"+txtEnroll.getText()+"'");
	                while(rs2.next())
	                {
	                	nxtsem=rs2.getInt(1)+1;
	                }
	                try
	                {
	                	Statement stmt1 = Main.con.createStatement();
	                stmt1.executeUpdate("update rps.student set semester='"+nxtsem+"' where enroll_no='"+txtEnroll.getText()+"'");
	                JOptionPane.showMessageDialog(null,"semester is updated successfully");	
	                }
	                catch (NumberFormatException ne){
		                JOptionPane.showMessageDialog(null,"To update the data first open the Table!");
		                return;
		            }catch (SQLException e1){
		                e1.printStackTrace();
		            }
	            }catch (NumberFormatException ne){
	                JOptionPane.showMessageDialog(null,"To update the data first open the Table!");
	                return;
	            }catch (SQLException e1){
	                e1.printStackTrace();
	            }
	    	}
	 }
}
