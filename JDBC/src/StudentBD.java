import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentBD {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="anushree";
       // String query="select * from student;";   ---> retrieve/read
      // String query="insert into student(rollno, name, age) values (5,'sparsh',26);";   ----->insert
      //  String query="delete from student where rollno = 3;"; //delete
        String query="update student set name = 'Cutie', age = 30 where rollno = 5;";  //update 

        try {
            Class.forName("com.mysql.jdbc.Driver");//load drivers
            System.out.println("Drivers loaded successfully");
 
            
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            }

        try {
            //establish connection
            Connection con=DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!!!!");
            //Statement interface to create statement to run query
            Statement stat=con.createStatement();
            //executing query and storing it in ResultSet interface
           // ResultSet res=stat.executeQuery(query);---->retrieve/read
             int rowsAffected= stat.executeUpdate(query); // create/update/delete/insert
             if(rowsAffected > 0){
                System.out.println("Updated successfully " + rowsAffected+ " row(s) affected.");
             }
             else{
                System.out.println("Updation failed");
             }

           // extract resul---->fetch, retrieve
          /*   while (res.next()) {
                int rollno=res.getInt("rollno");//pass column name
                String name=res.getString("name");
                int age=res.getInt("age");
                System.out.println();
                System.out.println("=========================");
                System.out.println("Roll no: "+ rollno);
                System.out.println("Name: "+name);
                System.out.println("Age: "+age);
            }

            // Close resources--->to prevent memory leaks
            res.close();
         */
            stat.close();
            con.close();
            System.out.println("Connection closed successfully!!!");


        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        }
}
