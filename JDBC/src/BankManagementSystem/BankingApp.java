package BankManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;;
public class BankingApp {

        private static final String url="jdbc:mysql://localhost:3306/bankingdb";
        private static final String username="root";
        private static final String password="anushree";

        public static void main(String[] args) throws ClassNotFoundException, SQLException{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Drivers loaded successfully");
            } catch (ClassNotFoundException e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
            try{
                Connection con=DriverManager.getConnection(url, username, password);
                Scanner sc=new Scanner(System.in); 
                //sharing instances to other classes
                User user=new User(con,sc);
                Accounts acc=new Accounts(con,sc);
                AccountManager man=new AccountManager(con,sc);
            
                String email;
                long accNo;

                while(true){
                    System.out.println("Welcome to Bank Management System");
                    System.out.println();
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.println("Enter your choice");
                    int choice=sc.nextInt();
                    switch (choice) {
                        case 1:
                        user.register();
                        System.out.println();
                        System.out.flush();
                        break;
                        case 2:
                        email=user.login();
                        if(ema)
                    
                        default:
                            break;
                    }
                }
            }
            
        }

  
}
