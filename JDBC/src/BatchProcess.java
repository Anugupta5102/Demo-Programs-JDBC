import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;
//In batch operating system the jobs were performed in batches. 
//This means Jobs having similar requirements are grouped and executed as a group to speed up processing.
//Reallife eg--> company sends salary, mail, message to employees in batches
public class BatchProcess {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        String url="jdbc:mysql://localhost:3306/mydb";
        String username="root";
        String password="anushree";
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully");
         } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
         }
         try{
            Connection con=DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
            con.setAutoCommit(false);
           /* 
           Statement stat=con.createStatement();
            stat.addBatch("insert into emp(id,name,role,salary) values(4,'Arun','Manager',40000)");
            stat.addBatch("insert into emp(id,name,role,salary) values(5,'varun','Developer',70000)");
            stat.addBatch("insert into emp(id,name,role,salary) values(6,'ali','Tester',10000)");
            int batchResult[]=stat.executeBatch(); 
            con.commit();
            System.out.println("Batch Executed Successfully");
           */
            String query="insert into emp(id,name,role,salary) values(?,?,?,?)";
            PreparedStatement prep=con.prepareStatement(query);
            Scanner sc=new Scanner(System.in);
            while(true) {
                System.out.print("Id: ");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name=sc.nextLine();
                System.out.print("Role: ");
                String role=sc.nextLine();
                System.out.print("Salary: ");
                double sal=sc.nextDouble();
                sc.nextLine();
                prep.setInt(1, id);
                prep.setString(2, name);
                prep.setString(3, role);
                prep.setDouble(4, sal);
                prep.addBatch();
                System.out.println("Want to add more: Y/N");
                String decision=sc.nextLine();
                if(decision.toUpperCase().equals("N")){
                    break;
                }   
            }
            int batchResult[]=prep.executeBatch();
            con.commit();
            System.out.println("Batch Executed Successfully");


         }catch(SQLException e){
            System.out.println(e.getMessage());
         }
    }
    
}
