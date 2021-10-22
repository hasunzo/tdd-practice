package com.practice.tdd.tddpractice.videoshop;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VideoShopTest {

    // 고객은 비디오를 대여한다.
    @Test
    public void testCustomerRent() {
        Customer customer = new Customer("홍길동");

        // 고객이 대여할 비디오
        Video movie = new Video(VideoType.MOVIE, 500);
        customer.rentVideo(movie, 3);

        Rental rental = new Rental(movie, 3);

        assertThat(rental, is(customer.getRentalList().get(0)));
    }

    // 시스템이 포인트 총합을 계산한다.
    @Test
    public void testCalculateTotalBonusPoint() {
        Customer customer = new Customer("홍길동");
        Video movie = new Video(VideoType.MOVIE, 500);
        customer.rentVideo(movie, 3);

        VideoShop videoShop = new VideoShop();
        assertThat(2, is(videoShop.calculateTotalBonusPoint(customer)));
    }

    // 시스템이 비디오 총 대여가격을 계산한다.
    @Test
    public void testCalculateTotalRentalCharge() {
        Customer customer = new Customer("홍길동");
        Video movie = new Video(VideoType.MOVIE, 500);
        customer.rentVideo(movie, 3);

        VideoShop videoShop = new VideoShop();
        assertThat(1250, is(videoShop.CalculateTotalRentalCharge(customer)));
    }

    // 시스템이 총 대여비디오 수를 계산한다.
    @Test
    public void testCalculateTotalRentalNumber() {
        Customer customer = new Customer("홍길동");

        Video movie = new Video(VideoType.MOVIE, 500);
        Video sport = new Video(VideoType.SPORT, 400);
        Video documentary = new Video(VideoType.DOCUMENTARY, 400);

        customer.rentVideo(movie, 3);
        customer.rentVideo(sport, 1);
        customer.rentVideo(documentary, 2);

        VideoShop videoShop = new VideoShop();
        assertThat(3, is(videoShop.CalculateTotalRentalNumber(customer)));
    }

    // 시스템이 비디오 일일 대여가격을 할인한다.
    @Test
    public void testDiscountRentalCharge() {
        Customer customer = new Customer("홍길동");

        Video movie = new Video(VideoType.MOVIE, 500);
        Video sport = new Video(VideoType.SPORT, 400);
        Video documentary = new Video(VideoType.DOCUMENTARY, 300);

        customer.rentVideo(movie, 4);
        customer.rentVideo(sport, 1);
        customer.rentVideo(documentary, 6);

        VideoShop videoShop = new VideoShop();
        assertThat(797, is(videoShop.DiscountRentalCharge(customer)));
    }

    // 시스템이 대여정보를 제공한다.
    @Test
    public void testGetRentalInfo() {
        StringBuilder rentalInfo = new StringBuilder();

        Customer customer = new Customer("홍길동");
        Video movie = new Video(VideoType.MOVIE, 500);
        customer.rentVideo(movie, 4);

        VideoShop videoShop = new VideoShop();
        rentalInfo.append(videoShop.CalculateTotalRentalNumber(customer));
        rentalInfo.append(customer.getRentalList().get(0).toString());
        rentalInfo.append(videoShop.CalculateTotalRentalCharge(customer));
        rentalInfo.append(videoShop.calculateTotalBonusPoint(customer));


        assertThat(rentalInfo.toString(), is(videoShop.getRentalInfo(customer)));
    }

}
