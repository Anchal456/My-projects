/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empdb;

/**
 *
 * @author anchal
 */
 
import java.io.*;
import java.sql.*;
import java.lang.Exception;
public class emp{  
public static void main(String args[])throws Exception{  
        Class.forName("org.apache.derby.jdbc.ClientDriver");  
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/employee_records"); 

        PreparedStatement ps=con.prepareStatement("insert into empl values(?,?,?,?,?)");  

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        do{  
        System.out.println("enter id:");  
        int id=Integer.parseInt(br.readLine());  
        System.out.println("enter firstname:");  
        String firstname=br.readLine(); 
        System.out.println("enter lastname:");  
        String lastname=br.readLine(); 
        System.out.println("enter salary:");  
        int salary=Integer.parseInt(br.readLine());  
        System.out.println("enter hire_date:");  
        String hire_date=br.readLine();

        ps.setInt(1,id);  
        ps.setString(2,firstname);  
        ps.setString(3,lastname);  
        ps.setInt(4,salary);  
        ps.setString(5,hire_date); 
        int i=ps.executeUpdate();  
        System.out.println(i+" records affected");  

        System.out.println("Do you want to continue: yes/no");  
        String s=br.readLine();  
        if(s.startsWith("n")){  
        break;  
        }  
        }while(true); 
      PreparedStatement  pst = con.prepareStatement(
  "SELECT * from empl");
         ResultSet rs;
           rs=pst.executeQuery();
           System.out.print("EMP_ID\t\tFirst Name\tLast Name\t SALARY\n");
           while(rs.next())
           {
               int id=rs.getInt("EMPLOYEE_id");
               String FNAME=rs.getString("FIRSTNAME");
               String LNAME=rs.getString("LASTNAME");
               int SAL=rs.getInt("SALARY");
               
               String DATE=rs.getString("HIRE_DATE");
                 
               System.out.println(id+"\t\t"+FNAME +"\t\t"+LNAME+"\t\t"+SAL);
              
           }
         
               System.out.println("\n");
               String sql3 = "SELECT * FROM EMPL";
               PreparedStatement pst3;
               pst3 = con.prepareStatement(sql3, ResultSet.TYPE_SCROLL_INSENSITIVE,
                           ResultSet.CONCUR_UPDATABLE);
               ResultSet rs1= null;
                rs1 = pst3.executeQuery();
                while(rs1.next())
                {
                    int sal_u = rs1.getInt("SALARY") + 500;
                    rs1.updateDouble( "SALARY", sal_u );
                    rs1.updateRow();
                   System.out.println(rs1.getInt("EMPLOYEE_id")+"\t"+rs1.getString("FIRSTNAME")+"\t"+rs1.getString("LASTNAME")+"\t"+rs1.getInt("SALARY"));

                }
                 System.out.println("REULT SET UPDATED SALARY BY 500\n");
        con.close();  
}}