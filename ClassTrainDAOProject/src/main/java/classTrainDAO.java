import java.sql.*;
import java.util.Scanner;

public class classTrainDAO {
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
            ResultSet trainDetails=statement.executeQuery(findTrain(trainNumber));
            while (trainDetails.next()){
                String trainName=trainDetails.getString("TRAIN_NAME");
                int trainNo= trainDetails.getInt("TRAIN_NO");
                int ticketPrice= trainDetails.getInt("TICKET_PRICE");
                String source=trainDetails.getString("SOURCE");
                String destination=trainDetails.getString("DESTINATION");
                getTrainDetails getTrainDetails=new getTrainDetails(trainNo,trainName,source,destination,ticketPrice);
                System.out.println(getTrainDetails);
            }
            System.out.println();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static String findTrain(int trainNumber){
        String trainDetails="select * from Trains where TRAIN_NO="+trainNumber;
        return trainDetails;
    }

}
