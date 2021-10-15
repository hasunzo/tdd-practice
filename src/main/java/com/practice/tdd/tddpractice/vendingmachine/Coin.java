package com.practice.tdd.tddpractice.vendingmachine;

import lombok.Getter;

import java.util.*;

@Getter
public class Coin {
    List<Integer> coins;

    Coin() {
        coins = new ArrayList<Integer>();
    }

    public void add(int coin) {
        coins.add(coin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(coins, coin.coins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coins);
    }
}
