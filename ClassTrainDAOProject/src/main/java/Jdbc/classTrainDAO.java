package Jdbc;

import model.Train;

import java.sql.*;

public class classTrainDAO {
    private static Connection connection=trainDB.getConnection();
    Train train;
    public static Train findTrain(int trainNumber) {
        Train train=null;
        try{
        trainDB.getConnection();
        Statement statement = connection.createStatement();
        String trainDetails = "select * from Trains where TRAIN_NO=" + trainNumber;
        ResultSet resultSet = statement.executeQuery(trainDetails);
        while (resultSet.next()) {
            String trainName = resultSet.getString("TRAIN_NAME");
            int trainNo = resultSet.getInt("TRAIN_NO");
            int ticketPrice = resultSet.getInt("TICKET_PRICE");
            String source = resultSet.getString("SOURCE");
            String destination = resultSet.getString("DESTINATION");
            train = new Train(trainNo, trainName, source, destination, ticketPrice);
            System.out.println(train);
        }
            return train;
        } catch (SQLException e) {
            System.out.println("Train not found");
        }
        return null;
    }
}
