import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
    public static void main(String[] args) throws Exception {
    //Database url
    String url="jdbc:mysql://localhost:3306/students";
    
    //Database credentials
    String username="root";
    String password="anushree";

    //Establish connection
    try(Connection connection= DriverManager.getConnection(url, username, password)){
    System.out.println("Connected to database.");
    System.out.println(connection);//id
     
    //perform operations
    } catch (SQLException e) {
        // TODO: handle exception
        System.err.println("Connection Failed: " + e.getMessage());
        }
    }
}
