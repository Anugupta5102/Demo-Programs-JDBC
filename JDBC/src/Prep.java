import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Prep {
    public static void main(String[] args) throws Exception {
    //Database url
    String url="jdbc:mysql://localhost:3306/students";

    //Database credentials
    String username="root";
    String password="anushree";

  /*   String query="select * from student where name= ? and age= ?"; //Retrive prepared statement query
    // ? means placeholder  */

    String query="insert into student(rollno, name, age) values(?, ?, ?)" ; // Insert
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");//load drivers
        System.out.println("Drivers loaded successfully");

        
    } catch (ClassNotFoundException e) {
        // TODO: handle exception
        System.out.println(e.getMessage());
        }

    //Establish connection
    try{
        Connection connection= DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database.");
        Scanner sc=new Scanner(System.in);
        int roll=sc.nextInt();
        sc.nextLine();
        String n=sc.nextLine();
        int ag=sc.nextInt();

    PreparedStatement prep=connection.prepareStatement(query);
    //Insert
    prep.setInt(1, roll);
    prep.setString(2, n);
    prep.setInt(3, ag);
    int rowsAffected=prep.executeUpdate();//insert
    if(rowsAffected > 0){
        System.out.println("Inserted successfully");
    }
    else{
        System.out.println("Insertion failed");
    }

    //Retrive
  /*   prep.setString(1, "vishu"); //setting placeholders value
       prep.setString(2, "24");
       ResultSet res=prep.executeQuery();//retrieve
       while(res.next()){
        int rollno=res.getInt("rollno");
        String name=res.getString("name");
        int age=res.getInt("age");

        System.out.println("Roll no: "+rollno);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
   */
  prep.close();
  connection.close();
   // res.close();
   

    //perform operations
    } catch (SQLException e) {
        // TODO: handle exception
        System.err.println("Connection Failed: " + e.getMessage());
    }
        
    }
}
    
