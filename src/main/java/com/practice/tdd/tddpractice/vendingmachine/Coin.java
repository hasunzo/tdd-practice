package com.practice.tdd.tddpractice.vendingmachine;

import lombok.Getter;

import java.util.*;

@Getter
public class Coin {
    List<Integer> Coins;

    Coin() {
        Coins = new ArrayList<Integer>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return Objects.equals(Coins, coin.Coins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Coins);
    }
}
