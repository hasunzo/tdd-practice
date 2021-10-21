package com.practice.tdd.tddpractice.videoshop;

import java.util.ArrayList;
import java.util.List;

public class VideoShop {

    // 포인트 총합 계산한다
    public int calculateTotalBonusPoint(Customer customer) {
        int totalBonusPoint = 0;

        for (Rental rental : customer.getRentalList()) {
            totalBonusPoint += rental.getVideo().getVideoType().getBonusPoint();
        }

        return totalBonusPoint;
    }

    // 비디오 총 대여가격을 계산한다.
    public int CalculateTotalRentalCharge(Customer customer) {
        int totalRentalCharge = 0;

        for (Rental rental : customer.getRentalList()) {
            totalRentalCharge += rental.getVideo().getRentalCharge() * rental.getRentalDays();
        }

        totalRentalCharge -= DiscountRentalCharge(customer);

        return totalRentalCharge;
    }

    // 총 대여비디오 수를 계산한다.
    public int CalculateTotalRentalNumber(Customer customer) {
        return customer.getRentalList().size();
    }

    // 비디오 일일 대여가격을 할인한다.
    public int DiscountRentalCharge(Customer customer) {
        int discountRentalCharge = 0;

        for (Rental rental : customer.getRentalList()) {
            switch (rental.getVideo().getVideoType()) {
                case MOVIE:
                    // 영화는 대여기간이 2일 이상 되면 3일째 부터는 대여요금이 1/2로 할인된다. -> 50%할인
                    for (int i = 3; i <= rental.getRentalDays(); i++) {
                        discountRentalCharge += rental.getVideo().getRentalCharge() * 0.5;
                    }
                    break;
                case DOCUMENTARY:
                    // 다큐멘터리는 대여기간이 3일 이상 되면 4일째 부터는 대여요금이 1/3로 할인된다. -> 33%할인
                    for (int i = 4; i <= rental.getRentalDays(); i++) {
                        discountRentalCharge += rental.getVideo().getRentalCharge() * 0.33;
                    }
                    break;
                default:
                    break;
            }
        }

        return discountRentalCharge;
    }

    // 대여정보를 제공한다.
    public String getRentalInfo(Customer customer) {
        StringBuffer rentalInfo = new StringBuffer();

        rentalInfo.append(CalculateTotalRentalNumber(customer));

        for (Rental rental : customer.getRentalList()) {
            rentalInfo.append(rental.toString());
        }

        rentalInfo.append(CalculateTotalRentalCharge(customer));
        rentalInfo.append(calculateTotalBonusPoint(customer));

        return rentalInfo.toString();
    }
}
