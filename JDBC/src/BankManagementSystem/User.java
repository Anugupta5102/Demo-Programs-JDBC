package BankManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    private Connection  con;
    private Scanner sc;

    public user(Connection con,Scanner sc){
        this.con=con;
        this.sc=sc;
    }

    public void register(){
        sc.nextLine();
        System.out.print("Full Name: ");
        String fname=sc.nextLine();
        System.out.print("Email: ");
        String email=sc.nextLine();
        System.out.print("Password: ");
        String password=sc.nextLine();
        if(user_exits(email)){
            System.out.println("User already exists!!");
            return;
        }
        String register_query = "INSERT INTO user(full_name, email, password) values(?, ?, ?)";
        try {
            PreparedStatement prep=con.prepareStatement(register_query);
            prep.setString(1, fname);
            prep.setString(2, email);
            prep.setString(3, password);
            int affectedrows=prep.executeUpdate();
            if(affectedrows > 0){
                System.out.println("Registered successfully");
            }
            else{
                System.out.println("Registration failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String login(){
        sc.nextLine();
        System.out.print("Email: ");
        String email=sc.nextLine();
        System.out.print("Password: ");
        String password=sc.nextLine();
        String login_query= "SELECT FROM user WHERE email = ? and password = ?";
        try {
            PreparedStatement prep=con.prepareStatement(login_query);
            prep.setString(1, email);
            prep.setString(2, password);
            ResultSet res=prep.executeQuery();
            if(res.next()){
                return email;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean user_exits(String email){
        String query= "SELECT * FROM user where email = ?";
        try{
            PreparedStatement prep=con.prepareStatement(query);
            prep.setString(1, email);
            ResultSet res= prep.executeQuery();
            if(res.next()){
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
}
