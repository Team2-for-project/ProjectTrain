package com.torryharris.model;

import java.util.Date;
import java.util.TreeMap;

public class Ticket {
    private int counter;
    private String pnr;
    private Date travelDate;
    private Train train;
    private TreeMap<Passenger, Integer> passenger = new TreeMap<>();
    Passenger p1 = new Passenger();

    public Ticket(Train train, Date travelDate) {
        this.train = train;
        this.travelDate = travelDate;
    }

    private String generatePNR() {
        int counter = 100;
        int n = train.getDestination().length();
        System.out.println("PNR :" + train.getSource().charAt(0) + train.getDestination().charAt(n - 1) + "_" + travelDate + "_" + counter);
        counter++;
        return generatePNR();
    }
}

