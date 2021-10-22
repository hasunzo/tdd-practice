package com.practice.tdd.tddpractice.videoshop;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Rental {
    private Video video;
    private int rentalDays;

    Rental(Video video, int rentalDays) {
        this.video = video;
        this.rentalDays = rentalDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return rentalDays == rental.rentalDays && Objects.equals(video, rental.video);
    }

    @Override
    public int hashCode() {
        return Objects.hash(video, rentalDays);
    }

    @Override
    public String toString() {
        return "Rental{" + video.toString() +
                ", rentalDays=" + rentalDays +
                '}';
    }
}
