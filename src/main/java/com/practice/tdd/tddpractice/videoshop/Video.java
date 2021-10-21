package com.practice.tdd.tddpractice.videoshop;

import lombok.Getter;

@Getter
public class Video {
    private VideoType videoType;
    private int rentalCharge;

    Video(VideoType type, int rentalCharge) {
        this.rentalCharge = rentalCharge;
        this.videoType = type;
    }

    @Override
    public String toString() {
        return "VideoType=" + videoType.name() +
                ", rentalCharge=" + rentalCharge;
    }
}
