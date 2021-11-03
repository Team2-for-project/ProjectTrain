package com.torryharris.trainultimate.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private char gender;

    @Override
    public int compareTo(Passenger o) {
        return name.compareTo(o.name);
    }

}