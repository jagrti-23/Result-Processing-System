package rps1;

import java.text.DecimalFormat;
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

public class MarksLogic implements ActionListener{
	JFrame frame;
	JLabel lblsub[]=new JLabel[10];
    JTextField txtsub1[]=new JTextField[10];
    JTextField txtsub2[]=new JTextField[10];
    JTextField txtsub3[]=new JTextField[10];
    JButton btnsubmit;
    JTextField txtay;
    JTextField txtrollno;
    String roll;int dcode;int sem;String id;
	MarksLogic(String roll,int dcode,int sem,String id)
	{
		this.roll=roll;
		this.dcode=dcode;
		this.sem=sem;
		this.id=id;
		try
		{

		Statement stmt = Main.con.createStatement();
        ResultSet rs = stmt.executeQuery("select sub_code,sub_name,cr_pr,cr_th,mm_th,mm_pr,mm_mt from rps.subject where dcode="+dcode+" and scheme_id='"+id+"' and semester="+sem+" ");
        frame= new JFrame("Marks Submission");
        frame.setLayout(null);
        btnsubmit=new JButton("Submit");
        btnsubmit.setBounds(330,650,80,30);
        frame.add(btnsubmit);
        JLabel lblth=new JLabel("Theory");
        lblth.setBounds(220,150,80,30);
        frame.add(lblth);
        JLabel lblpr=new JLabel("Practical");
        lblpr.setBounds(420,150,80,30);
        frame.add(lblpr);
        JLabel lblmt=new JLabel("Mid Term");
        lblmt.setBounds(320,150,80,30);
        frame.add(lblmt);
        JLabel lblay=new JLabel("Academic Year");
        lblay.setBounds(20,100,80,30);
        frame.add(lblay);
        JLabel lblrollno=new JLabel("Roll No.");
        lblrollno.setBounds(20,50,80,30);
        frame.add(lblrollno);
        txtay=new JTextField();
        txtay.setBounds(120,100,80,30);
        frame.add(txtay);
        txtrollno=new JTextField();
        txtrollno.setBounds(120,50,80,30);
        frame.add(txtrollno);
        frame.setVisible(true);
        frame.setBounds(300,50,700,750);

        int n=0,i=0,y=150;
        while(rs.next())
        {
        lblsub[i]=new JLabel();
        lblsub[i].setText(rs.getString(2));
        lblsub[i].setBounds(20,50+y,180,30);
        frame.add(lblsub[i]);
        txtsub1[i]=new JTextField();
        txtsub1[i].setBounds(220,50+y,80,30);
        frame.add(txtsub1[i]);
        txtsub2[i]=new JTextField();
        txtsub2[i].setBounds(420,50+y,80,30);
        frame.add(txtsub2[i]);
        if(rs.getInt(3)==0)
        {
        	txtsub2[i].setVisible(false);
        }
        if(rs.getInt(4)==0)
        {
        	txtsub1[i].setVisible(false);
        }
        txtsub3[i]=new JTextField();
        txtsub3[i].setBounds(320,50+y,80,30);
        frame.add(txtsub3[i]);
        y=y+50;
        n++;
        i++;
        }
        btnsubmit.addActionListener(this);
		}
		catch (NumberFormatException ne){
            JOptionPane.showMessageDialog(null,"error");
            return;
        }catch (SQLException e1){
            e1.printStackTrace();
        }
		
		
	}
	 @Override
	    public void actionPerformed(ActionEvent e) {
	        if(e.getSource()==btnsubmit){
	               DecimalFormat df=new DecimalFormat("#.##");
	        	try
	    		{
	    		Statement stmt = Main.con.createStatement();
	            ResultSet rs1 = stmt.executeQuery("select sub_code,sub_name,cr_pr,cr_th,mm_th,mm_pr,mm_mt from rps.subject where dcode="+dcode+" and scheme_id='"+id+"' and semester="+sem+" ");
	            int i=0;
	            double max_total=0;
	            double total_gp=0,total_cp=0,sgpa=0,ogpa=0;
	            while(rs1.next())
	            {
	                int th;
	                //= Integer.parseInt(txtsub1[i].getText());
	                int mt = Integer.parseInt(txtsub3[i].getText());
	                int pr;
	                if(rs1.getInt(3)==0)
	                	pr=0;
	                else
	                    pr = Integer.parseInt(txtsub2[i].getText());
	                if(rs1.getInt(4)==0)
	                	th=0;
	                else
	                    th = Integer.parseInt(txtsub1[i].getText());
	                i++;
	               int th_total=th+mt;
	               int pr_total=pr+mt;
	               int total=0;
	               double gp=0,cp=0;
	               String thstatus,prstatus;

	               if(rs1.getInt(3)==0)
	               {
	            	   if(th_total>=32)
	            	   { thstatus="pass";
	            	   max_total=max_total+(rs1.getInt(3)+rs1.getInt(4));
	            	   total=th_total;
	            	   gp=total/10.0;
	                   cp=gp*(rs1.getInt(4)+rs1.getInt(3));
	                   total_gp=total_gp+gp;
	                   total_cp=total_cp+cp;}
	            	   else
	            		   thstatus="fail";
	            	   
	            	  //total_gp=Math.round(total_gp*100.0)/100.0;
	            	   //total_cp=Math.round(total_cp*100.0)/100.0;
	            	   try {
	            		   Statement stmt1 = Main.con.createStatement();
	                   stmt1.executeUpdate("insert into rps.marks(Enroll_no,Sub_code,Marks_mt,Marks_th,Marks_pr,Th_total,Pr_total,Res_th,Res_pr,Total,Grade_pt,Credit_pt,scheme_id) values('"+roll+"','"+rs1.getString(1)+"',"+mt+","+th+","+null+","+th_total+","+null+",'"+thstatus+"',"+null+","+total+","+df.format(gp)+","+df.format(cp)+",'"+id+"')"); 
	            	   }
	            	   catch (NumberFormatException ne){
	   	                JOptionPane.showMessageDialog(null,"something went wrong");
	   	                return;
	   	            }catch (SQLException e1){
	   	                e1.printStackTrace();
	   	            }
	            	   System.out.println("executed2"); 
	               }
	               else if(rs1.getInt(4)==0)
	               {
	            	   if(pr_total>=32)
	            	   { prstatus="pass";
	            	   max_total=max_total+(rs1.getInt(3)+rs1.getInt(4));
	            	   total=pr_total;
	            	   gp=total/10.0;
	                   cp=gp*(rs1.getInt(3)+rs1.getInt(4));
	                   total_gp=total_gp+gp;
	                   total_cp=total_cp+cp;}
	            	   else
	            		   prstatus="fail";
	            	  //total_gp=Math.round(total_gp*100.0)/100.0;
	            	   //total_cp=Math.round(total_cp*100.0)/100.0;
	            	   try {
	            		   Statement stmt1 = Main.con.createStatement();
	                   stmt1.executeUpdate("insert into rps.marks(Enroll_no,Sub_code,Marks_mt,Marks_th,Marks_pr,Th_total,Pr_total,Res_th,Res_pr,Total,Grade_pt,Credit_pt,scheme_id) values('"+roll+"','"+rs1.getString(1)+"',"+mt+","+null+","+pr+","+null+","+pr_total+","+null+",'"+prstatus+"',"+total+","+df.format(gp)+","+df.format(cp)+",'"+id+"')"); 
	            	   }
	            	   catch (NumberFormatException ne){
	   	                JOptionPane.showMessageDialog(null,"something went wrong");
	   	                return;
	   	            }catch (SQLException e1){
	   	                e1.printStackTrace();
	   	            }
	            	   System.out.println("executed2"); 
	               }
	               else
	               {
	               if(th_total>=28)
	            	   thstatus="pass";
	               else
	            	   thstatus="fail";
	               if(pr_total>=20)
	            	   prstatus="pass";
	               else
	            	   prstatus="fail";
	               if(th_total>=28&&pr_total>=20)
	               {
	            	   max_total=max_total+(rs1.getInt(3)+rs1.getInt(4));
	            	   total=th_total+pr_total-mt;
	                  gp=total/10.0;
	                  cp=gp*(rs1.getInt(3)+rs1.getInt(4));
	                  total_gp=total_gp+gp;
	                  total_cp=total_cp+cp;
	               }
	              // total_gp=Math.round(total_gp*100.0)/100.0;
            	  // total_cp=Math.round(total_cp*100.0)/100.0;
            	   try {
            		   Statement stmt2 = Main.con.createStatement();
                  
	                stmt2.executeUpdate("insert into rps.marks(Enroll_no,Sub_code,Marks_mt,Marks_th,Marks_pr,Th_total,Pr_total,Res_th,Res_pr,Total,Grade_pt,Credit_pt,scheme_id) values('"+roll+"','"+rs1.getString(1)+"',"+mt+","+th+","+pr+","+th_total+","+pr_total+",'"+thstatus+"','"+prstatus+"',"+total+","+df.format(gp)+","+df.format(cp)+",'"+id+"')"); 
            	   }catch (NumberFormatException ne){
	   	                JOptionPane.showMessageDialog(null,"something went wrong");
	   	                return;
	   	            }catch (SQLException e1){
	   	                e1.printStackTrace();
	   	            }
            	   }
	            
	            }
	            JOptionPane.showMessageDialog(null,"Marks inserted successfully");
	          sgpa=total_cp/max_total;
	          try {
       		   Statement stmt3 = Main.con.createStatement();
       		   ResultSet r=stmt3.executeQuery("select ogpa from rps.result where enroll_no="+"'"+roll+"'");
       		
       		
	          if(r.next()==false)
	          {	ogpa=sgpa;
	          try {
    		   Statement stmt4 = Main.con.createStatement();
          
	          stmt4.executeUpdate("insert into rps.result(enroll_no,scheme_id,acad_year,semester,roll_no,sgpa,ogpa) values('"+roll+"','"+id+"','"+txtay.getText()+"',"+sem+","+Integer.parseInt(txtrollno.getText())+","+df.format(sgpa)+","+df.format(ogpa)+")");
       	   }catch (NumberFormatException ne){
 	                JOptionPane.showMessageDialog(null,"something went wrong");
 	                return;
 	            }catch (SQLException e1){
 	                e1.printStackTrace();
 	            }}
	          else {        try
	      	{
	          	Statement stmt5 = Main.con.createStatement();
	              ResultSet rs5 = stmt.executeQuery("select credit_pt,cr_th,cr_pr from rps.marks m,rps.subject s where m.sub_code=s.sub_code and enroll_no='"+roll+"'");
        		  double max_cp=0,stu_cp=0;
	              while(rs5.next()) {
	            	  
        			 stu_cp=stu_cp+rs5.getDouble(1);
        			 max_cp=max_cp+(rs5.getInt(2)+rs5.getInt(3));
     
        		  }
        		  ogpa=stu_cp/max_cp;
	              
	      	}catch (NumberFormatException ne){
                JOptionPane.showMessageDialog(null,"something went wrong");
                return;
            }catch (SQLException e1){
                e1.printStackTrace();
            }  
          //sgpa=Math.round(sgpa*100.0)/100.0;
 	      //ogpa=Math.round(ogpa*100.0)/100.0;
        		  try {
           		   Statement stmt5 = Main.con.createStatement();
                 
       	          stmt5.executeUpdate("update rps.result set sgpa="+df.format(sgpa)+", ogpa="+df.format(ogpa)+", semester="+sem+" , roll_no="+Integer.parseInt(txtrollno.getText())+", acad_year="+txtay.getText()+" where enroll_no='"+roll+"'");
              	   }catch (NumberFormatException ne){
        	                JOptionPane.showMessageDialog(null,"something went wrong");
        	                return;
        	            }catch (SQLException e1){
        	                e1.printStackTrace();
        	            }
          }
            }catch (NumberFormatException ne){
	                JOptionPane.showMessageDialog(null,"something went wrong");
	                return;
	            }catch (SQLException e1){
	                e1.printStackTrace();
	            }
	          System.out.println("executed4");
	          txtrollno.setText(null);
	            txtay.setText(null);
	          new ResultLogic(roll,dcode,sem,id);
	    		}
	    		catch (NumberFormatException ne){
	                JOptionPane.showMessageDialog(null,"something went wrong");
	                return;
	            }catch (SQLException e1){
	                e1.printStackTrace();
	            }
	    		
	 }
	 }
	 
	 }


