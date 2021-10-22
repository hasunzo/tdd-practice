package com.practice.tdd.tddpractice.videoshop;

import lombok.Getter;

@Getter
public enum VideoType {
    MOVIE(1), SPORT(2), DOCUMENTARY(1);

    private int bonusPoint;

    VideoType(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }
}
