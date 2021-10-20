package Driver;
import Jdbc.classTrainDAO;
import model.*;
import java.text.ParseException;
import java.util.Date;
import java.sql.*;
import java.text.*;
import java.util.Scanner;

public class TicketApplication {
    public static void main(String[] args) throws ParseException {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the Train number");
        Date travelDate;
        String dateString;
        int trainNumber=scan.nextInt();
        Train train=classTrainDAO.findTrain(trainNumber);

        System.out.println("Enter the date you want to travel:");
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate=d;
        while (true) {
            dateString=scan.next();
            travelDate = s.parse(dateString);
                if (travelDate.compareTo(currentDate)<0) {
                    System.out.println("Enter a correct date");
                }
                else {
                    break;
                }
        }

        System.out.println("Enter total number of passengers:");
        int noOfPassengers= scan.nextInt();
        Ticket ticket=new Ticket(train,dateString);
       // Passenger passenger;
        for(int i=1;i<=noOfPassengers;i++) {
            System.out.println("Enter details of Passenger "+i);
            System.out.println("Enter Passenger Name:");
            String name=scan.next();
            System.out.println("Enter Passenger Age:");
            int age=scan.nextInt();
            System.out.println("Enter Passenger Gender:");
            char gender=scan.next().charAt(0);
            ticket.addPassengers(name,age,gender);
        }
        for(Passenger p:ticket.getPassengersMap().keySet()){
            System.out.println(p+":"+ticket.getPassengersMap().get(p));
        }
        ticket.writeTicket();
        System.out.println("Ticket booked successfully");
    }

}
