package com.github.liyibo1110.pattern.state.v2.state;

import com.github.liyibo1110.pattern.state.v2.VendingMachine;

/**
 * @author liyibo
 * @date 2025-12-08 14:05
 */
public class WaitToSelectGoodsState implements VendingState {
    private final VendingMachine vendingMachine;

    public WaitToSelectGoodsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("UNSUPPORTED OPERATION：已投币，请选择商品");
    }

    @Override
    public void selectGoods() {
        // 由VendingMachine自己来负责切换
        this.vendingMachine.nextState();
        System.out.println("选中XX商品");
    }

    @Override
    public void dispense() {
        System.out.println("UNSUPPORTED OPERATION：未选择商品，无法出货");
    }
}
