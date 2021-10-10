package Jdbc;

import model.Train;

import java.sql.*;

public class classTrainDAO {
    private static Connection connection=trainDB.getConnection();
    public static void findTrain(int trainNumber) throws SQLException {
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
            Train Train = new Train(trainNo, trainName, source, destination, ticketPrice);
            System.out.println(Train);

        }
    }
}
