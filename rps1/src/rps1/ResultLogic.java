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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

public class ResultLogic {
	String roll;int dcode;int sem;String id;
	ResultLogic(String roll,int dcode,int sem,String id)
	{
		this.roll=roll;
		this.dcode=dcode;
		this.sem=sem;
		this.id=id;
	try
	{
	Statement stmt7 = Main.con.createStatement();
    ResultSet rs7 = stmt7.executeQuery("select * from rps.result where enroll_no='"+roll+"' ");
    JFrame frame=new JFrame("Result");
    JLabel lblsgpa=new JLabel("SGPA");
    lblsgpa.setBounds(20,50,80,30);
    frame.add(lblsgpa);
    JLabel lblogpa=new JLabel("OGPA");
    lblogpa.setBounds(20,100,80,30);
    frame.add(lblogpa);
    rs7.next();
    JLabel txtsgpa=new JLabel(rs7.getString(6));
    txtsgpa.setBounds(120,50,80,30);
    frame.add(txtsgpa);
    JLabel lbllogpa=new JLabel(rs7.getString(7));
    lbllogpa.setBounds(120,100,80,30);
    frame.add(lbllogpa);
    frame.setVisible(true);
    frame.setLayout(null);
    frame.setBounds(501,401,220,220);
	}
	catch (NumberFormatException ne){
        JOptionPane.showMessageDialog(null,"something went wrong ");
        return;
    }catch (SQLException e1){
        e1.printStackTrace();
    }
	}
}
