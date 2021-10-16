package com.practice.tdd.tddpractice.vendingmachine;

public class ChangeModule {
    enum COIN{
        KRW500(500), KRW100(100), KRW50(50), KRW10(10);
        private int value;
        COIN(int value) {
            this.value = value;
        }
    }
    
    public CoinSet getCoin(int balance) {
        CoinSet coinSet = new CoinSet();

        final int KRW500 = COIN.KRW500.value;
        final int KRW100 = COIN.KRW100.value;
        final int KRW50 = COIN.KRW50.value;
        final int KRW10 = COIN.KRW10.value;

        balance = addCoinsToCoinSet(balance, coinSet, KRW500);
        balance = addCoinsToCoinSet(balance, coinSet, KRW100);
        balance = addCoinsToCoinSet(balance, coinSet, KRW50);
        balance = addCoinsToCoinSet(balance, coinSet, KRW10);

        return coinSet;
    }

    private int addCoinsToCoinSet(int balance, CoinSet coinSet, int KRW500) {
        while(balance >= KRW500) {
            coinSet.add(KRW500);
            balance -= KRW500;
        }
        return balance;
    }

}
