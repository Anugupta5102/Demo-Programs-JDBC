package BankManagementSystem;

import java.sql.Connection;
import java.util.Scanner;

public class Accounts {
    
    private Connection con;
    private Scanner sc;

    public Accounts(Connection con, Scanner sc){
        this.con=con;
        this.sc=sc;
    }

    public long open_account(String email){

    }

    public long getAccount_number(String email){

    }

    private long generateAccount_number(){

    }

    public boolean account_exist(String email){
        
    }
}

