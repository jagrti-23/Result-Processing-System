package rps1;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
import java.sql.*;
import rps1.Main;
import rps1.StudentDetails;
import rps1.StudentTable;
public class StudentLogic extends JFrame implements ActionListener{

    JButton btnAdd,btnUpdate,btnDelete,btnShow,btnMarks,btnRes;
    JTextField txtRoll,txtAyr,txtFName,txtMName,txtLName,txtId,txtDcode,txtDob,txtAddress,txtPhone,txtEmail,txtGender,txtSem,txtClg;
    JLabel lblRoll,lblAyr,lblFName,lblMName,lblLName,lblId,lblDcode,lblDob,lblAddress,lblPhone,lblEmail,lblGender,lblSem,lblClg;
    JTable jTable;
    Container c;

    StudentLogic(){
        //set Title of JFrame
        super("Student Form");

        // adding container to JFrame
        c = getContentPane();

        // setting Layout of JFrame to NUll
        c.setLayout(null);

        //Creating Label Text for each TextField and adding to container
        lblRoll = new JLabel("Enroll No. : ");
        lblRoll.setBounds(20,50,80,30);
        c.add(lblRoll);
        txtRoll =  new JTextField();
        txtRoll.setBounds(120,50,200,30);
        c.add(txtRoll);
        lblAyr = new JLabel("Admitted year : ");
        lblAyr.setBounds(340,50,80,30);
        c.add(lblAyr);
        txtAyr =  new JTextField();
        txtAyr.setBounds(440,50,200,30);
        c.add(txtAyr);
        lblFName = new JLabel("First Name : ");
        lblFName.setBounds(20,100,100,30);
        c.add(lblFName);
        txtFName =  new JTextField();
        txtFName.setBounds(120,100,200,30);
        c.add(txtFName);
        lblMName = new JLabel("Middle Name : ");
        lblMName.setBounds(20,150,100,30);
        c.add(lblMName);
        txtMName =  new JTextField();
        txtMName.setBounds(120,150,200,30);
        c.add(txtMName);
        lblLName = new JLabel("Last Name : ");
        lblLName.setBounds(20,200,100,30);
        c.add(lblLName);
        txtLName =  new JTextField();
        txtLName.setBounds(120,200,200,30);
        c.add(txtLName);
        lblId = new JLabel("Scheme Id : ");
        lblId.setBounds(340,100,100,30);
        c.add(lblId);
        txtId =  new JTextField();
        txtId.setBounds(440,100,200,30);
        c.add(txtId);
        lblDcode = new JLabel("Department Code : ");
        lblDcode.setBounds(340,150,100,30);
        c.add(lblDcode);
        txtDcode =  new JTextField();
        txtDcode.setBounds(440,150,200,30);
        c.add(txtDcode);
        lblDob = new JLabel("Date of Birth : ");
        lblDob.setBounds(340,200,100,30);
        c.add(lblDob);
        txtDob =  new JTextField();
        txtDob.setBounds(440,200,200,30);
        c.add(txtDob);
        lblAddress = new JLabel("Enter Address : ");
        lblAddress.setBounds(20,250,150,30);
        c.add(lblAddress);
        txtAddress =  new JTextField();
        txtAddress.setBounds(120,250,200,30);
        c.add(txtAddress);
        lblPhone = new JLabel("Mobile No. : ");
        lblPhone.setBounds(20,300,100,30);
        c.add(lblPhone);
        txtPhone =  new JTextField();
        txtPhone.setBounds(120,300,200,30);
        c.add(txtPhone);
        lblEmail = new JLabel("Mail Id : ");
        lblEmail.setBounds(20,350,100,30);
        c.add(lblEmail);
        txtEmail =  new JTextField();
        txtEmail.setBounds(120,350,200,30);
        c.add(txtEmail);
        lblGender = new JLabel("Gender : ");
        lblGender.setBounds(340,250,150,30);
        c.add(lblGender);
        txtGender =  new JTextField();
        txtGender.setBounds(440,250,200,30);
        c.add(txtGender);
        lblSem = new JLabel("Semester : ");
        lblSem.setBounds(340,300,150,30);
        c.add(lblSem);
        txtSem =  new JTextField();
        txtSem.setBounds(440,300,200,30);
        c.add(txtSem);
        lblClg = new JLabel("College Name : ");
        lblClg.setBounds(340,350,150,30);
        c.add(lblClg);
        txtClg =  new JTextField();
        txtClg.setBounds(440,350,200,30);
        c.add(txtClg);



        //creating button and adding to container
        btnAdd = new JButton("Add");
        btnAdd.setBounds(10,400,80,40);
        c.add(btnAdd);
        btnShow = new JButton("Show");
        btnShow.setBounds(110,400,80,40);
        c.add(btnShow);
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(210,400,80,40);
        c.add(btnUpdate);
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(310,400,80,40);
        c.add(btnDelete);
        btnMarks = new JButton("Marks");
        btnMarks.setBounds(410,400,80,40);
        c.add(btnMarks);
        btnRes = new JButton("Result");
        btnRes.setBounds(510,400,80,40);
        c.add(btnRes);

        //adding action Listener to each Button
        btnAdd.addActionListener(this);
        btnShow.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnMarks.addActionListener(this);
        btnRes.addActionListener(this);

    }

    ArrayList<StudentDetails> getStudents(){
        ArrayList<StudentDetails> studentData = new ArrayList<>();
        try{
            Statement stmt = Main.con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rps.student");
            StudentDetails studentDetails;
            while(rs.next()){
                String roll = rs.getString(1);
                String ayr = rs.getString(2);
                String fname = rs.getString(3);
                String mname = rs.getString(4);
                String lname = rs.getString(5);
                String id = rs.getString(6);
                int dcode = rs.getInt(7);
                String dob= rs.getString(8);
                String address = rs.getString(9);
                String phone = rs.getString(10);
                String mail = rs.getString(11);
                String gender = rs.getString(12);
                int sem = rs.getInt(13);
                String clg = rs.getString(14);
                studentDetails = new StudentDetails(roll,ayr,fname,mname,lname,id,dcode,dob,address,phone,mail,gender,sem,clg);
                studentData.add(studentDetails);
            }
        }catch(SQLException e1){
            e1.printStackTrace();
        }
        return studentData;
    }

    JTable getTable(){
        Vector<Object> columnData = new Vector<>();
        columnData.add("Enroll No.");
        columnData.add("Academic Year");
        columnData.add("FName");
        columnData.add("MName");
        columnData.add("LName");
        columnData.add("Scheme Id");
        columnData.add("Dcode");
        columnData.add("Dob");
        columnData.add("Address");
        columnData.add("Phone");
        columnData.add("Email");
        columnData.add("Gender");
        columnData.add("Sem");
        columnData.add("College");
        Vector<Vector<Object>> data = new Vector<>();
        ArrayList<StudentDetails> list = getStudents();
        for (StudentDetails studentDetails : list) {
            Vector<Object> row = new Vector<>();
            row.add(studentDetails.getStudentRoll());
            row.add(studentDetails.getStudentAdmYr());
            row.add(studentDetails.getStudentFName());
            row.add(studentDetails.getStudentMName());
            row.add(studentDetails.getStudentLName());
            row.add(studentDetails.getId());
            row.add(studentDetails.getDCode());
            row.add(studentDetails.getDob());
            row.add(studentDetails.getStudentAddress());            
            row.add(studentDetails.getStudentPhone());
            row.add(studentDetails.getStudentMail());
            row.add(studentDetails.getStudentGender());
            row.add(studentDetails.getStudentSem());
            row.add(studentDetails.getStudentCollege());
            data.add(row);
        }
        jTable = new JTable(data,columnData);
        return jTable;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd){
        	String roll = txtRoll.getText();
        	String ayr = txtAyr.getText();
            String fname = txtFName.getText();
            String mname = txtMName.getText();
            String lname = txtLName.getText();
            String id = txtId.getText();
            int dcode = Integer.parseInt(txtDcode.getText());
            String dob = txtDob.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            String mail = txtEmail.getText();
            String gender = txtGender.getText();
            int sem = Integer.parseInt(txtSem.getText());
            String clg = txtClg.getText();
            try{
                Statement stmt = Main.con.createStatement();
                stmt.executeUpdate("insert into rps.student(enroll_no,admi_year,fname,mname,lname,scheme_id,dcode,bdate,address,phone,email,gender,semester,college) values('"+roll+"','"+ayr+"','"+fname+"','"+mname+"','"+lname+"','"+id+"',"+dcode+",'"+dob+"','"+address+"','"+phone+"','"+mail+"','"+gender+"',"+sem+",'"+clg+"')");
                JOptionPane.showMessageDialog(null,"Data inserted Successfully");
            }catch (SQLException e1){
            	JOptionPane.showMessageDialog(null,"Data is not inserted");	
                e1.printStackTrace();
            }
            txtRoll.setText(null);
            txtAyr.setText(null);
            txtFName.setText(null);
            txtMName.setText(null);
            txtLName.setText(null);
            txtId.setText(null);
            txtDcode.setText(null);
            txtDob.setText(null);
            txtAddress.setText(null);
            txtPhone.setText(null);
            txtEmail.setText(null);
            txtGender.setText(null);
            txtSem.setText(null);
            txtClg.setText(null);
        }else if(e.getSource()==btnShow){
            jTable = getTable();
            new StudentTable(jTable,"Student Table");
            jTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row_index = jTable.getSelectedRow();                                       
                    txtRoll.setText(jTable.getValueAt(row_index,0).toString());
                    txtAyr.setText(jTable.getValueAt(row_index,1).toString());
                    txtFName.setText(jTable.getValueAt(row_index,2).toString());
                    txtMName.setText(jTable.getValueAt(row_index,3).toString());
                    txtLName.setText(jTable.getValueAt(row_index,4).toString());
                    txtId.setText(jTable.getValueAt(row_index,5).toString());
                    txtDcode.setText(jTable.getValueAt(row_index,6).toString());
                    txtDob.setText(jTable.getValueAt(row_index,7).toString());
                    txtAddress.setText(jTable.getValueAt(row_index,8).toString());
                    txtPhone.setText(jTable.getValueAt(row_index,9).toString());
                    txtEmail.setText(jTable.getValueAt(row_index,10).toString());
                    txtGender.setText(jTable.getValueAt(row_index,11).toString());
                    txtSem.setText(jTable.getValueAt(row_index,12).toString());
                    txtClg.setText(jTable.getValueAt(row_index,13).toString());
                }
            });
        }else if(e.getSource()==btnUpdate){
            UpdateLogic ul=new UpdateLogic();
            txtRoll.setText(null);
            txtAyr.setText(null);
            txtFName.setText(null);
            txtMName.setText(null);
            txtLName.setText(null);
            txtId.setText(null);
            txtDcode.setText(null);
            txtDob.setText(null);
            txtAddress.setText(null);
            txtPhone.setText(null);
            txtEmail.setText(null);
            txtGender.setText(null);
            txtSem.setText(null);
            txtClg.setText(null);
        }
        else if(e.getSource()==btnMarks){
        	jTable = getTable();
            new StudentTable(jTable,"Student Table");
            
            jTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                  int row_index = jTable.getSelectedRow();
                   String roll=jTable.getValueAt(row_index,0).toString();
                   int dcode=Integer.parseInt(jTable.getValueAt(row_index,6).toString());
                    int sem=Integer.parseInt(jTable.getValueAt(row_index,12).toString());
                    String id=jTable.getValueAt(row_index,5).toString();
                   
                   
            try{
            	MarksLogic m=new MarksLogic(roll,dcode,sem,id);
                /*Statement stmt = Main.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select sub_code,sub_name,cr_pr,cr_th,mm_th,mm_pr,mm_mt from rps.subject where dcode="+dcode+" and scheme_id='"+id+"' and semester="+sem+" ");
                JFrame frame= new JFrame("Marks Submission");
                frame.setLayout(null);
                JLabel lblsub[]=new JLabel[10];
                JTextField txtsub1[]=new JTextField[10];
                JTextField txtsub2[]=new JTextField[10];
                JTextField txtsub3[]=new JTextField[10];
                JButton btnsubmit=new JButton("Submit");
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
                JTextField txtay=new JTextField();
                txtay.setBounds(120,100,80,30);
                frame.add(txtay);
                JTextField txtrollno=new JTextField();
                txtrollno.setBounds(120,50,80,30);
                frame.add(txtrollno);
                frame.setVisible(true);
                frame.setSize(700,700);

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
                txtsub3[i]=new JTextField();
                txtsub3[i].setBounds(320,50+y,80,30);
                frame.add(txtsub3[i]);
                y=y+50;
                n++;
                i++;
                }
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                i=0;
                rs.first();
                int max_total=0;
                double total_gp=0,total_cp=0,sgpa=0,ogpa;
                while(rs.next())
                {
                    int th = Integer.parseInt(txtsub1[i].getText());
                    int mt = Integer.parseInt(txtsub3[i].getText());
                    int pr;
                    if(rs.getInt(2)==0)
                    	pr=0;
                    else
                        pr = Integer.parseInt(txtsub2[i].getText());
                    i++;
                   int th_total=th+mt;
                   int pr_total=pr+mt;
                   int total;
                   double gp=0,cp=0;
                   String thstatus,prstatus;
                   if(rs.getInt(3)==0)
                   {
                	   if(th_total>=32)
                	   { thstatus="pass";
                	   max_total=max_total+rs.getInt(5)+rs.getInt(6)+rs.getInt(7);
                	   total=th_total;
                	   gp=total/10;
                       cp=gp*(rs.getInt(4));
                       total_gp=total_gp+gp;
                       total_cp=total_cp+cp;}
                	   else
                		   thstatus="fail";
                	   
                       stmt.executeQuery("insert into rps.marks(Enroll_no,Sub_code,Marks_mt,Marks_th,Th_total,Res_th,Total,Grade_pt,Credit_pt) values('"+roll+"','"+rs.getString(1)+"',"+mt+","+th+","+th_total+",'"+thstatus+"',"+gp+","+cp+")"); 
                       
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
                   total=th_total+pr_total;
                   if(th_total>=28&&pr_total>=20)
                   {
                	   max_total=max_total+rs.getInt(5)+rs.getInt(6)+rs.getInt(7);
                	   total=th_total+pr_total-mt;
                      gp=total/10;
                      cp=gp*(rs.getInt(3)+rs.getInt(4));
                      total_gp=total_gp+gp;
                      total_cp=total_cp+cp;
                   }
                    stmt.executeQuery("insert into rps.marks(Enroll_no,Sub_code,Marks_mt,Marks_th,Marks_pr,Th_total,Pr_total,Res_th,Res_pr,Total,Grade_pt,Credit_pt) values('"+roll+"','"+rs.getString(1)+"',"+mt+","+th+","+pr+","+th_total+","+pr_total+",'"+thstatus+"','"+prstatus+"',"+gp+","+cp+")"); 
                    
                }
                
                }  
              max_total=max_total/10;
              sgpa=total_gp/max_total;
              ResultSet r=stmt.executeQuery("select ogpa from rps.result where enroll_no="+"'"+roll+"'");
              ogpa=(r.getDouble(1)+sgpa)/2;
              stmt.executeQuery("insert into rps.result(enroll_no,scheme_id,acad_year,semester,roll_no,sgpa,ogpa) values('"+roll+"','"+id+"','"+txtay.getText()+"',"+sem+","+Integer.parseInt(txtrollno.getText())+","+sgpa+","+ogpa+")");
              */
            }catch (NumberFormatException ne){
                JOptionPane.showMessageDialog(null,"To enter marks the data first open the Table!");
                return;
            }
            //catch (SQLException e1){
              //  e1.printStackTrace();
            //}
            }});
            txtRoll.setText(null);
            txtAyr.setText(null);
            txtFName.setText(null);
            txtMName.setText(null);
            txtLName.setText(null);
            txtId.setText(null);
            txtDcode.setText(null);
            txtDob.setText(null);
            txtAddress.setText(null);
            txtPhone.setText(null);
            txtEmail.setText(null);
            txtGender.setText(null);
            txtSem.setText(null);
            txtClg.setText(null);
        }
            else if(e.getSource()==btnDelete){
            jTable = getTable();
            new StudentTable(jTable,"Student Table");
            jTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row_index = jTable.getSelectedRow();
                    txtRoll.setText(jTable.getValueAt(row_index,0).toString());
                    int response = JOptionPane.showConfirmDialog(null,"Do you want to delete ? ","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(response==JOptionPane.YES_OPTION){
                        try{
                            Statement stmt = Main.con.createStatement();
                            System.out.println(txtRoll.getText());
                            stmt.executeUpdate("delete from rps.student where enroll_no='"+txtRoll.getText()+"'");
                            JOptionPane.showMessageDialog(null,"student entry is deleted");	
                        }catch (SQLException e1){
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null,"student entry is not deleted");	
                        }
                        jTable = getTable();
                        new StudentTable(jTable,"Updated Table");
                    }else{
                        txtRoll.setText(null);
                    }
                }
            });
            txtRoll.setText(null);
            txtAyr.setText(null);
            txtFName.setText(null);
            txtMName.setText(null);
            txtLName.setText(null);
            txtId.setText(null);
            txtDcode.setText(null);
            txtDob.setText(null);
            txtAddress.setText(null);
            txtPhone.setText(null);
            txtEmail.setText(null);
            txtGender.setText(null);
            txtSem.setText(null);
            txtClg.setText(null);
        }
            else if(e.getSource()==btnRes){ShowResult s=new ShowResult();}
    }

}
