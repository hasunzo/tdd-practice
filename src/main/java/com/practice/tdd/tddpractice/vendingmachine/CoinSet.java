package com.practice.tdd.tddpractice.vendingmachine;

import lombok.Getter;

import java.util.*;

@Getter
public class CoinSet {
    List<Integer> coins;

    CoinSet() {
        coins = new ArrayList<Integer>();
    }

    public void add(int coin) {
        coins.add(coin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinSet coinSet = (CoinSet) o;
        return Objects.equals(coins, coinSet.coins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coins);
    }
}
