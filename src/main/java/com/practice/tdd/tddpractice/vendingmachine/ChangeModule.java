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

        // 넘겨받은 변수에 직접 대입이 일어나지 않도록
        // remainChangeAmount라는 지역 변수를 지정
        int remainBalance = balance;
        for (COIN coin : COIN.values()) {
            remainBalance = addCoinsToCoinSet(remainBalance, coinSet, coin.value);
        }

        return coinSet;
    }

    private int addCoinsToCoinSet(int balance, CoinSet coinSet, int coinValue) {
        while(balance >= coinValue) {
            coinSet.add(coinValue);
            balance -= coinValue;
        }
        return balance;
    }

}
