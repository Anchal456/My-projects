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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EmpDb {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Connection con=null;
       Statement stmt=null;
       Statement stmt1=null;
       PreparedStatement pstmt=null;
       try
       {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           con=DriverManager.getConnection("jdbc:derby://localhost:1527/employee_records");
           stmt=con.createStatement();
           ResultSet rs;
           rs=stmt.executeQuery("Select * from Empl");
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
           
           String sql="UPDATE  EMPL set SALARY=35000 WHERE EMPLOYEE_ID=3 ";
           int count= stmt.executeUpdate(sql);
           System.out.print("\n\n----After updating the table----\n\n");
           System.out.println("Updated Record: "+count);
           sql="SELECT * from EMPL";
           rs=stmt.executeQuery(sql);
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
           
          String sql1 = "INSERT INTO EMPL (employee_id, firstname, lastname,salary,HIRE_DATE) VALUES (?, ?, ?, ?,?)";
          pstmt=con.prepareStatement(sql1);
          pstmt.setInt(1, 103);
          pstmt.setString(2, "Sanjana ");
          pstmt.setString(3, "Pandey");
        pstmt.setInt(4,45000);
          pstmt.setString(5, "2008");
           int rowsInserted = pstmt.executeUpdate();
              if (rowsInserted > 0)
               {
                    System.out.println("A new employee was inserted successfully!\n");
              }
           String sql2="DELETE from EMPl where employee_id=104";
          stmt1=con.createStatement();
          stmt.executeUpdate(sql2);
          System.out.println("Deleted Record successfully");
         
          System.out.println("\n\n---Table after different operations-----\n\n");
          rs=stmt.executeQuery(sql);
           System.out.print("EMP_ID\tFirst Name Last Name SALARY\n");
           while(rs.next())
           {
               int id=rs.getInt("EMPLOYEE_id");
               String FNAME=rs.getString("FIRSTNAME");
               String LNAME=rs.getString("LASTNAME");
               int SAL=rs.getInt("SALARY");
               
               String DATE=rs.getString("HIRE_DATE");
                 
               System.out.println(id+"\t\t"+FNAME +"\t\t"+LNAME+"\t\t"+SAL);
              
           }
           rs.close();
       }
       catch(SQLException se)
       {
           se.printStackTrace();
       }
    
   }
}
   