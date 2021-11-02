package com.torryharris.trainultimate.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Train {
    @Id
    private int trainNo;
    private String trainName,source,destination;
    private double ticketPrice;

}
