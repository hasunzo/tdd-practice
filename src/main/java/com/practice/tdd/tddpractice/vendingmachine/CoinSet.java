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
    public boolean equals(Object coinSet) {
        if (!(coinSet instanceof CoinSet)) {
            return false;
        }

        return this.toString().equals(coinSet.toString());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer coin : this.coins) {
            builder.append(coin);
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(coins);
    }
}
