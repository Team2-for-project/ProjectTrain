package model;

import java.util.Date;
import java.util.TreeMap;

public class Ticket extends Train {
    private int counter;
    private String pnr;
    private Date travelDate;
    private Train train;
    public int numberOfPassengers;

    Passenger passenger = new Passenger();

    public Ticket() {
    }

    public Ticket(Train train, Date travelDate) {
        this.train = train;
        this.travelDate = travelDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    private String generatePNR() {
        int counter = 100;
        int n = train.getDestination().length();
        System.out.println("PNR :" + train.getSource().charAt(0) + train.getDestination().charAt(n - 1) + "_" + travelDate + "_" + counter);
        counter++;
        return generatePNR();
    }

    private double calcPassengerFare(Passenger passenger) {
        double fare;
        if (passenger.getAge() <= 12) {
            fare = passenger.getTicketPrice() * 0.5;
        } else if (passenger.getAge() >= 60) {
            fare = passenger.getTicketPrice() * 0.6;
        } else if (passenger.getGender() == 'F') {
            fare = passenger.getTicketPrice() * 0.75;
        }
        return calcPassengerFare(passenger);
    }

    public void addPassengers(String name, int age, char gender) {
        TreeMap<Passenger, Integer> passengersMap = new TreeMap<>();

        for (int i = 1; i <= numberOfPassengers; i++) {
            passengersMap.put(passenger, i);
        }

    }

    private double totalTicketPrice() {
        double totalFare = 0;
        totalFare += calcPassengerFare(passenger);
        return totalFare;

    }

    private void generateTicket() {

        System.out.println("PNR : " + generatePNR());
        System.out.println("Train no : " + getTrainNo());
        System.out.println("Train Name : " + getTrainName());
        System.out.println("From : " + getSource());
        System.out.println("To : " + getDestination());
        System.out.println("Travel Date : " + travelDate);
        System.out.println();
        for (int i = 1; i <= numberOfPassengers; i++) {
            System.out.println("Passengers : " + i);
            System.out.println("Name" + "  " + "Age" + "  " + "Gender" + "  " + "Fare");
            System.out.println(passenger.getName() + "  " + passenger.getAge() + "  " + passenger.getGender() + "  " + calcPassengerFare(passenger));

        }
    }
}






