package com.practice.tdd.tddpractice.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendingMachineTest {

    //잔액확인
    @Test
    public void testGetChangeAmount() throws Exception {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(100);
        assertThat("투입금액 100원", 100, is(machine.balance));

        machine.putCoin(500);
        assertThat("투입금액 500원", 600, is(machine.balance));
    }

    //음료수 뽑기
    @Test
    public void testSelectDrink() {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(500);
        machine.putCoin(500);
        Drink cola = new Drink("콜라", 700);
        machine.selectDrink(cola);
        assertThat("천원 추가 후 콜라(700원) 선택", 300, is(machine.balance));

        machine.putCoin(500);
        Drink cider = new Drink("사이다", 700);
        machine.selectDrink(cider);
        assertThat("오백원 추가 후 사이다(700원) 선택", 100, is(machine.balance));
    }

    //잔돈 반환
    //100원
    @Test
    public void testReturnChangeHundred() {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(800);

        Drink cola = new Drink("콜라", 700);
        machine.selectDrink(cola);

        Coin coin = new Coin();
        coin.Coins.add(100);

        assertThat(coin, is(machine.getCoins()));
    }

    //잔돈 반환
    //160원
    @Test
    public void testReturnChangeTen() {
        VendingMachine machine = new VendingMachine();
        machine.putCoin(900);

        Drink cola = new Drink("콜라", 740);
        machine.selectDrink(cola);

        Coin coin = new Coin();
        coin.Coins.add(100);
        coin.Coins.add(50);
        coin.Coins.add(10);

        assertThat(coin, is(machine.getCoins()));
    }



}
