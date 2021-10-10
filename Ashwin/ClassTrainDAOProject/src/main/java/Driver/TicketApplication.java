package Driver;

import Jdbc.classTrainDAO;
import model.Ticket;
import model.Train;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TicketApplication {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        try{
            System.out.println("Enter the Train number");
            int trainNumber=scan.nextInt();
            classTrainDAO.findTrain(trainNumber);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("Enter trail details:");
        System.out.println("Enter the date you want to travel:");
        //System.out.println(java.time.LocalDate.now());
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("ddMMyyyy");
        int currentDate=Integer.parseInt(s.format(d));
        while (true) {
            int travelDate = scan.nextInt();
            if (travelDate < currentDate) {
                System.out.println("Enter a correct date");
            }
            else {
                break;
            }
        }
        //System.out.println(currentDate);
        System.out.println("Enter total number of passengers:");
        int noOfPassengers= scan.nextInt();
        Ticket ticket=new Ticket();
        ticket.setNumberOfPassengers(noOfPassengers);


    }

}
