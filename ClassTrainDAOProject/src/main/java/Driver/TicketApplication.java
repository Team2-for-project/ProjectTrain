package Driver;

import Jdbc.classTrainDAO;
import model.Train;

import java.sql.*;
import java.util.Scanner;

public class TicketApplication {
    static Connection connection;
    public static void main(String[] args) {
        try{
            Scanner scan=new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/traindetails";
            String username="root";
            String password="Elonmusk@123";
            connection= DriverManager.getConnection(url,username,password);
            System.out.println("Connected to DB");
            System.out.println();
            Statement statement=connection.createStatement();
            System.out.println("Enter the Train number");
            int trainNumber=scan.nextInt();
            ResultSet trainDetails=statement.executeQuery(classTrainDAO.findTrain(trainNumber));
           // classTrainDAO.printTrainDetails(trainDetails);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Enter trail details:");





    }
}
