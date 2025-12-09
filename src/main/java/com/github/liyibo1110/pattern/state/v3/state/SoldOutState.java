package com.github.liyibo1110.pattern.state.v3.state;

import com.github.liyibo1110.pattern.state.v3.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:16
 */
public class SoldOutState implements VendingState {
    private static final VendingState INSTANCE = new SoldOutState();


    public static VendingState instance() {
        return INSTANCE;
    }

    private SoldOutState() {

    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：商品已售罄");
    }

    @Override
    public void selectGoods(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：商品已售罄");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("UNSUPPORTED OPERATION：商品已售罄");
    }
}
