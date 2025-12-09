package com.github.liyibo1110.pattern.state.v2.state;

import com.github.liyibo1110.pattern.state.v2.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:05
 */
public class WaitToInsertCoinState implements VendingState {
    private final VendingMachine vendingMachine;

    public WaitToInsertCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        // 由VendingMachine自己来负责切换
        this.vendingMachine.nextState();
        System.out.println("投币成功，请选择商品");
    }

    @Override
    public void selectGoods() {
        System.out.println("UNSUPPORTED OPERATION：请先投币");
    }

    @Override
    public void dispense() {
        System.out.println("UNSUPPORTED OPERATION：请先投币");
    }
}
