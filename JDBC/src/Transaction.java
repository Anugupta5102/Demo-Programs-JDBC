import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//ACID---(atomicity,consistency,isolation,durability)
public class Transaction {
    public static void main(String[] args) throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql://localhost:3306/mydb";
        String username="root";
        String password="anushree";

        String debitQuery = "update accounts set balance = balance - ? where acc_no = ?";
        String creditQuery= "update accounts set balance = balance + ? where acc_no = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!!");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception 
            System.out.println(e.getMessage());
        }

        try {
            Connection con=DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
            con.setAutoCommit(false);//does not auto commit
            try{
            PreparedStatement debitStatement =con.prepareStatement(debitQuery);
            PreparedStatement creditStatement = con.prepareStatement(creditQuery);
            debitStatement.setDouble(1, 500.00); //set balance to be debited
            debitStatement.setString(2, "acc2"); // set account no from which balance is to be debited
            creditStatement.setDouble(1, 500.00);
            creditStatement.setString(2, "acc3");
            int rowsAffectedDebit = debitStatement.executeUpdate();
            int rowsAffectedCredit = creditStatement.executeUpdate();
            if(rowsAffectedCredit > 0 && rowsAffectedDebit > 0){
            con.commit();
            System.out.println("Transanction Successful");
            }
            else{
                con.rollback();
                System.out.println("Transaction Failed");
            }
            }catch(SQLException e){
               System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
}
