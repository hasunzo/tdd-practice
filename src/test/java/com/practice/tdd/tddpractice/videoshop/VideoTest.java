package com.practice.tdd.tddpractice.videoshop;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VideoTest {

    // 각 비디오 타입은 포인트를 갖는다.
    @Test
    public void testVideoTypeHaveBonusPoint() {
        assertThat(1, is(VideoType.MOVIE.getBonusPoint()));
        assertThat(2, is(VideoType.SPORT.getBonusPoint()));
    }

    // 각 비디오는 비디오타입을 갖는다.
    // 각 비디오는 대여요금을 갖는다.
    // 각 비디오 타입은 포인트를 갖는다.
    @Test
    public void testVideoHaveVideoType() {
        Video movie = new Video(VideoType.MOVIE, 500);

        assertThat(1, is(movie.getVideoType().getBonusPoint()));
        assertThat(500, is(movie.getRentalCharge()));
    }

    // 각 대여는 대여일수를 갖는다.
    @Test
    public void testRentalHaveRentalDays() {
        Video movie = new Video(VideoType.MOVIE, 500);
        Rental rental = new Rental(movie, 3);
        assertThat(3, is(rental.getRentalDays()));
    }

    // 각 고객은 이름을 갖는다.
    @Test
    public void testCustomerHaveName() {
        Customer customer = new Customer("홍길동");
        assertThat("홍길동", is(customer.getName()));
    }
}
