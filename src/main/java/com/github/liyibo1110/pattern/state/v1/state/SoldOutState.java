package com.github.liyibo1110.pattern.state.v1.state;

import com.github.liyibo1110.pattern.state.v1.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 13:58
 */
public class SoldOutState implements VendingState {
    private final VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("UNSUPPORTED OPERATION：商品已售罄");
    }

    @Override
    public void selectGoods() {
        System.out.println("UNSUPPORTED OPERATION：商品已售罄");
    }

    @Override
    public void dispense() {
        System.out.println("UNSUPPORTED OPERATION：商品已售罄");
    }
}
