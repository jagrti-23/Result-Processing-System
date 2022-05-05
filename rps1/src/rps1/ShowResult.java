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

public class ShowResult implements ActionListener{
	String roll;JTextField txtEnroll;
	JLabel lbllRoll,lbllAyr,lbllName,lbllDob,lbllEmail,lbllSem,lbllClg,lblsc,lblsn,lblcr,lblmarks,lblgp,lblcp,lblth,lblpr,lblth1,lblpr1,lblmt;
    JLabel lbllgr,lbltotal,lblERoll,lblRoll,lblAyr,lblName,lblDcode,lblDob,lblAddress,lblEmail,lblSem,lblClg;
    JLabel lblcode[]=new JLabel[10],lblsname[]=new JLabel[10],lbllcrth[]=new JLabel[10],lbllcrpr[]=new JLabel[10],lbllth[]=new JLabel[10],lbllpr[]=new JLabel[10],lbllmt[]=new JLabel[10],lblltotal[]=new JLabel[10],lbllgp[]=new JLabel[10],lbllcp[]=new JLabel[10];
    JFrame frame,frame1;
    JButton btnRoll;
    int sem;

    ShowResult(){
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
          int y=30;
        frame=new JFrame(" Student Result ");
        // setting Layout of JFrame to NUll
        frame.setLayout(null);
        try
    	{
    	Statement stmt = Main.con.createStatement();
        ResultSet rs1 = stmt.executeQuery("select * from rps.student where enroll_no='"+roll+"'");

        //Creating Label Text for each TextField and adding to container
        while(rs1.next()) {
        	this.sem=rs1.getInt(13);
        lblRoll = new JLabel("Enroll No. : ");
        lblRoll.setBounds(20,120,80,30);
        frame.add(lblRoll);
        lbllRoll =  new JLabel();
        lbllRoll.setBounds(120,120,200,30);
        frame.add(lbllRoll);
        lblAyr = new JLabel("Admitted year : ");
        lblAyr.setBounds(340,120,120,30);
        frame.add(lblAyr);
        lbllAyr =  new JLabel();
        lbllAyr.setBounds(480,120,200,30);
        frame.add(lbllAyr);
        lblName = new JLabel("Name : ");
        lblName.setBounds(20,160,100,30);
        frame.add(lblName);
        lbllName =  new JLabel();
        lbllName.setBounds(120,160,200,30);
        frame.add(lbllName);
        lblDob = new JLabel("Date of Birth : ");
        lblDob.setBounds(340,160,120,30);
        frame.add(lblDob);
        lbllDob =  new JLabel();
        lbllDob.setBounds(480,160,200,30);
        frame.add(lbllDob);
        lblEmail = new JLabel("Mail Id : ");
        lblEmail.setBounds(20,200,100,30);
        frame.add(lblEmail);
        lbllEmail =  new JLabel();
        lbllEmail.setBounds(120,200,200,30);
        frame.add(lbllEmail);
        lblSem = new JLabel("Semester : ");
        lblSem.setBounds(340,200,120,30);
        frame.add(lblSem);
        lbllSem =  new JLabel();
        lbllSem.setBounds(480,200,200,30);
        frame.add(lbllSem);
        lbllClg =  new JLabel();
        lbllClg.setBounds(140,30,800,60);
        lbllClg.setFont(new Font("Serif",Font.BOLD,25));
        lbllgr =  new JLabel("STUDENT'S GRADE REPORT");
        lbllgr.setBounds(280,65,800,60);
        lbllgr.setFont(new Font("Serif",Font.BOLD,20));
        frame.add(lbllgr);
        frame.add(lbllClg);
        lbllName.setText(""+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5)+"");
        lbllRoll.setText(rs1.getString(1));
        lbllAyr.setText(rs1.getString(2));
        lbllDob.setText(rs1.getString(8));
        lbllEmail.setText(rs1.getString(11));
        lbllSem.setText(rs1.getString(13));
        lbllClg.setText(rs1.getString(14));
        }
    	}catch (NumberFormatException ne){
            JOptionPane.showMessageDialog(null,"To enter marks the data first open the Table!");
            return;
        }catch (SQLException e1){
            e1.printStackTrace();
        }
		try
	{
		lblsc=new JLabel("Subject code");
		lblsc.setBounds(20,260,120,30);
		frame.add(lblsc);
		lblsn=new JLabel("Subject Name");
		lblsn.setBounds(160,260,250,30);
		frame.add(lblsn);
		lblcr=new JLabel("Credit Hours");
		lblcr.setBounds(420,260,120,30);
		frame.add(lblcr);
		lblth=new JLabel("Th");
		lblth.setBounds(425,280,30,30);
		frame.add(lblth);
		lblpr=new JLabel("Pr");
		lblpr.setBounds(475,280,30,30);
		frame.add(lblpr);
		lblmarks=new JLabel("Marks Obtained");
		lblmarks.setBounds(540,260,120,30);
		frame.add(lblmarks);
		lblth1=new JLabel("Th");
		lblth1.setBounds(550,280,30,30);
		frame.add(lblth1);
		lblpr1=new JLabel("Pr");
		lblpr1.setBounds(580,280,30,30);
		frame.add(lblpr1);
		lblmt=new JLabel("MT");
		lblmt.setBounds(610,280,30,30);
		frame.add(lblmt);
		lbltotal=new JLabel("Total");
		lbltotal.setBounds(630,280,30,30);
		frame.add(lbltotal);
		lblgp=new JLabel("Grade Points");
		lblgp.setBounds(670,260,120,30);
		frame.add(lblgp);
		lblcp=new JLabel("Credit Points");
		lblcp.setBounds(790,260,120,30);
		frame.add(lblcp);
	Statement stmt2 = Main.con.createStatement();
    ResultSet rs2 = stmt2.executeQuery("select * from rps.marks m,rps.subject s where m.enroll_no='"+roll+"' and m.sub_code=s.sub_code and s.semester="+sem+"");
     int i=0;
    while(rs2.next()) {
    	lblcode[i]=new JLabel();
    	lblcode[i].setBounds(20,270+y,120,30);
    	frame.add(lblcode[i]);
    	lblsname[i]=new JLabel();
    	lblsname[i].setBounds(160,270+y,250,30);
    	frame.add(lblsname[i]);
    	lbllcrth[i]=new JLabel();
    	lbllcrth[i].setBounds(430,270+y,30,30);
    	frame.add(lbllcrth[i]);
    	lbllcrpr[i]=new JLabel();
    	lbllcrpr[i].setBounds(480,270+y,30,30);
    	frame.add(lbllcrpr[i]);
    	lbllth[i]=new JLabel();
    	lbllth[i].setBounds(550,270+y,30,30);
    	frame.add(lbllth[i]);
    	lbllpr[i]=new JLabel();
    	lbllpr[i].setBounds(580,270+y,30,30);
    	frame.add(lbllpr[i]);
    	lbllmt[i]=new JLabel();
    	lbllmt[i].setBounds(610,270+y,30,30);
    	frame.add(lbllmt[i]);
    	lblltotal[i]=new JLabel();
    	lblltotal[i].setBounds(640,270+y,30,30);
    	frame.add(lblltotal[i]);
    	lbllgp[i]=new JLabel();
    	lbllgp[i].setBounds(690,270+y,30,30);
    	frame.add(lbllgp[i]);
    	lbllcp[i]=new JLabel();
    	lbllcp[i].setBounds(810,270+y,30,30);
    	frame.add(lbllcp[i]);
    	y=y+20;
    	lblcode[i].setText(rs2.getString(2));
    	lblsname[i].setText(rs2.getString(16));
    	lbllcrth[i].setText(rs2.getString(19));
    	lbllcrpr[i].setText(rs2.getString(20));
    	lbllth[i].setText(rs2.getString(4));
    	lbllpr[i].setText(rs2.getString(5));
    	lbllmt[i].setText(rs2.getString(3));
    	lblltotal[i].setText(rs2.getString(10));
    	lbllgp[i].setText(rs2.getString(11));
    	lbllcp[i].setText(rs2.getString(12));
    	i++;
    	
	}
	}
	catch (NumberFormatException ne){
        JOptionPane.showMessageDialog(null,"To enter marks the data first open the Table!");
        return;
    }catch (SQLException e1){
        e1.printStackTrace();
    }
		try
		{
		Statement stmt5 = Main.con.createStatement();
	    ResultSet rs = stmt5.executeQuery("select sgpa,ogpa,semester from rps.result where enroll_no='"+roll+"' ");
	    JLabel lblsgpa=new JLabel("Grade Point Average for the Semester(SGPA):");
	    lblsgpa.setBounds(20,300+y,300,30);
	    frame.add(lblsgpa);
	    JLabel lblogpa=new JLabel("Overall Grade Point Average(OGPA)");
	    lblogpa.setBounds(20,350+y,300,30);
	    frame.add(lblogpa);
	    JLabel txtsgpa=new JLabel();
	    txtsgpa.setBounds(330,300+y,80,30);
	    frame.add(txtsgpa);
	    JLabel txtogpa=new JLabel();
	    txtogpa.setBounds(330,350+y,80,30);
	    frame.add(txtogpa);
	    while(rs.next()) {
	    txtsgpa.setText(rs.getString(1));
	    txtogpa.setText(rs.getString(2));
		}
	    frame.setVisible(true);
	    frame.setLayout(null);
	    frame.setBounds(400,50,900,700);
		}
		catch (NumberFormatException ne){
	        JOptionPane.showMessageDialog(null,"To enter marks the data first open the Table!");
	        return;
	    }catch (SQLException e1){
	        e1.printStackTrace();
	    }

    }
	}
}


