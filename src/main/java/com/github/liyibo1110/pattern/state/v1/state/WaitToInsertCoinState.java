package com.github.liyibo1110.pattern.state.v1.state;

import com.github.liyibo1110.pattern.state.v1.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 13:59
 */
public class WaitToInsertCoinState implements VendingState {
    private final VendingMachine vendingMachine;

    public WaitToInsertCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        this.vendingMachine.changeState(new WaitToSelectGoodsState(this.vendingMachine));
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
