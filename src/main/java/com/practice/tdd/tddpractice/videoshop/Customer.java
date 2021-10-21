package com.practice.tdd.tddpractice.videoshop;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer {
    private String name;
    private List<Rental> rentalList = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    public void rentVideo(Video video, int rentalDays) {
        Rental rental = new Rental(video, rentalDays);
        rentalList.add(rental);
    }

}
