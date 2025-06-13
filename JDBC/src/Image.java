import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Image {
    public static void main(String[] args) throws Exception {
        //Database url
        String url="jdbc:mysql://localhost:3306/students";
    
        //Database credentials
        String username="root";
        String password="anushree";
        //INSERT image from folder to database
        //String imgpath="C:\\Users\\DELL\\Downloads\\3.jpg";  
        // String query="insert into images(data) values(?)";--->insert

        //RETRIEVE image from database to folder 
        String folderpath= "C:\\Users\\DELL\\Downloads\\";
        String query="select data from images where id = ?";
       
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
            //INSERT
        /*  FileInputStream fs=new FileInputStream(imgpath); //convert image to binary-->byte
            byte imgdata[]=new byte[fs.available()];//array to store bytes accessible
            fs.read(imgdata);
            PreparedStatement prep=connection.prepareStatement(query);
            prep.setBytes(1, imgdata);//placeholder position,value
            int rowsAffected=prep.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Image inserted");
            }
            else{
                System.out.println("Image not inserted");
            }
        */
            //RETRIEVE
            PreparedStatement prep=connection.prepareStatement(query);
            prep.setInt(1, 1);
            ResultSet res=prep.executeQuery();
            if(res.next()){
                byte imgdata[]=res.getBytes("data");
                String imgpath= folderpath+"extractedImage.jpg";
                OutputStream out=new FileOutputStream(imgpath);//covert byte to image
                out.write(imgdata);
                System.out.println("Image found");
            }
            else{
                System.out.println("Image not found");
            }

            } catch (SQLException e) {
        // TODO: handle exception
        System.err.println("Connection Failed: " + e.getMessage());
            }catch (FileNotFoundException e){
                throw new RuntimeException(e);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        
    }
    
}
