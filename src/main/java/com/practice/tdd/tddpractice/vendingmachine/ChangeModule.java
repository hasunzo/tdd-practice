package com.practice.tdd.tddpractice.vendingmachine;

public class ChangeModule {
    enum COIN{
        KRW500(500), KRW100(100), KRW(50), KRW(10);
        private int value;
        COIN(int value) {
            this.value = value;
        }
    }
    public Coin getCoin(int balance) {
        Coin coin = new Coin();

        // 500원
        while(balance >= 500) {
            coin.add(500);
            balance -= 500;
        }

        // 100원
        while(balance >= 100) {
            coin.add(100);
            balance -= 100;
        }

        // 50원
        while(balance >= 50) {
            coin.add(50);
            balance -= 50;
        }

        // 10원
        while(balance >= 10) {
            coin.add(10);
            balance -= 10;
        }

        return coin;
    }
}
