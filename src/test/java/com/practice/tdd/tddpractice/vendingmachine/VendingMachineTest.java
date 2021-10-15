package com.practice.tdd.tddpractice.vendingmachine;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VendingMachineTest {
    //100원
    @Test
    public void testReturnChangeHundred() {
        ChangeModule module = new ChangeModule();
        Coin coins = new Coin();
        coins.add(100);
        assertThat(coins, is(module.getCoin(100)));
    }

    //잔돈 반환
    //160원
    @Test
    public void testReturnChangeTen() {
        ChangeModule module = new ChangeModule();
        Coin coins = new Coin();
        coins.add(100);
        coins.add(50);
        coins.add(10);
        assertThat(coins, is(module.getCoin(160)));
    }



}
