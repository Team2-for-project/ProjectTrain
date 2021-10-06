package Jdbc;

import model.Train;

import java.sql.*;

public class classTrainDAO {
    public static String findTrain(int trainNumber) {
        String trainDetails = "select * from Trains where TRAIN_NO=" + trainNumber;
        return trainDetails;
    }

    public static void printTrainDetails(ResultSet trainDetails) throws SQLException {
        while (trainDetails.next()) {
            String trainName = trainDetails.getString("TRAIN_NAME");
            int trainNo = trainDetails.getInt("TRAIN_NO");
            int ticketPrice = trainDetails.getInt("TICKET_PRICE");
            String source = trainDetails.getString("SOURCE");
            String destination = trainDetails.getString("DESTINATION");
            Train Train = new Train(trainNo, trainName, source, destination, ticketPrice);
            System.out.println(Train);
        }

    }
}
