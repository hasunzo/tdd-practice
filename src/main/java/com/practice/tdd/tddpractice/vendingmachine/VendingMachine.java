package com.practice.tdd.tddpractice.vendingmachine;

import lombok.Getter;

@Getter
public class VendingMachine {
    int balance;

    public void putCoin(int coin) {
        balance += coin;
    }

    public void selectDrink(Drink drink) {
        balance -= drink.price;
    }

    public CoinSet getCoins() {
        CoinSet coinSet = new CoinSet();

        // 500원
        while(balance >= 500) {
            coinSet.add(500);
            balance -= 500;
        }

        // 100원
        while(balance >= 100) {
            coinSet.add(100);
            balance -= 100;
        }

        // 50원
        while(balance >= 50) {
            coinSet.add(50);
            balance -= 50;
        }

        // 10원
        while(balance >= 10) {
            coinSet.add(10);
            balance -= 10;
        }

        return coinSet;
    }
}
